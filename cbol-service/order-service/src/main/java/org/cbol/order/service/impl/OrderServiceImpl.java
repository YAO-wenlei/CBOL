package org.cbol.order.service.impl;

import cn.hutool.core.convert.Convert;
import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cbol.common.errorcode.BaseErrorCode;
import org.cbol.common.exception.ClientException;
import org.cbol.common.exception.RemoteException;
import org.cbol.common.exception.ServerException;
import org.cbol.common.page.PageResponse;
import org.cbol.common.result.Result;
import org.cbol.common.util.BeanUtil;
import org.cbol.database.util.PageUtil;
import org.cbol.order.dao.entity.OrderDO;
import org.cbol.order.dao.entity.OrderItemDO;
import org.cbol.order.dao.mapper.OrderMapper;
import org.cbol.order.enums.OrderErrorEnum;
import org.cbol.order.enums.OrderStatusEnum;
import org.cbol.order.enums.OrderTypeEnum;
import org.cbol.order.remote.GameRemoteService;
import org.cbol.order.remote.vo.GameInfoVO;
import org.cbol.order.service.OrderItemService;
import org.cbol.order.service.OrderService;
import org.cbol.order.vo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderDO> implements OrderService {

    private final PlatformTransactionManager transactionManager;
    private final OrderItemService orderItemService;
    private final GameRemoteService gameRemoteService;

    @Override
    public String createOrder(OrderCreateVO orderCreateVO) {
        //todo 订单参数校验
        /*
         * 座位锁定
         * 对于cbol1.0版本 购票锁座位逻辑为 直接扣减球馆座位数量，直到余票等于0张 通过数据库update乐观锁实现
         * 2.0版本 对于球场选座逻辑支持座位号选座，前端展示球馆具体座位号，后端通过分布式锁实现购票逻辑
         */
        boolean success = lockSeatV1(orderCreateVO);
        if (!success){
            throw new ServerException("抱歉!余票数量不足！");
        }
        //todo 订单号生成
        String orderSn = UUID.randomUUID().toString().replace("-", "");
        List<OrderItemCreateVO> orderItemCreateVOList = orderCreateVO.getOrderItemCreateVOList();
        List<OrderItemDO> orderItemDOList = new ArrayList<>();
        orderItemCreateVOList.forEach(each ->{
            OrderItemDO orderItem = OrderItemDO.builder()
                    .orderSn(orderSn)
                    .gameId(each.getGameId())
                    .arenaId(each.getArenaId())
                    .seatSn(each.getSeatSn())
                    .realName(each.getRealName())
                    .idCard(each.getIdCard())
                    .idType(each.getIdType())
                    .phone(each.getPhone())
                    .amount(each.getAmount() * 100)
                    .status(OrderStatusEnum.PENDING_PAYMENT.getStatus())
                    .build();
            orderItemDOList.add(orderItem);
        });
        int totalAmount = orderItemCreateVOList.stream().mapToInt(OrderItemCreateVO::getAmount).sum();
        OrderDO order = OrderDO.builder()
                .orderSn(orderSn)
                .userId(orderCreateVO.getUserId())
                .gameId(orderCreateVO.getGameId())
                .competitionTime(orderCreateVO.getCompetitionTime())
                .arenaId(orderCreateVO.getArenaId())
                .totalAmount(totalAmount * 100)
                .source(orderCreateVO.getSource())
                .type(OrderTypeEnum.NORMAL.getType())
                .status(OrderStatusEnum.PENDING_PAYMENT.getStatus())
                .build();
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = transactionManager.getTransaction(transactionDefinition);
        try{
            this.getBaseMapper().insert(order);
            orderItemService.saveBatch(orderItemDOList);
            transactionManager.commit(transactionStatus);
        }catch (Exception ex){
            log.error("订单创建失败,参数[{}]", JSON.toJSON(orderCreateVO));
            transactionManager.rollback(transactionStatus);
            throw ex;
        }
        //todo 通过mq延迟关闭订单
        return orderSn;
    }

    @Override
    public OrderQueryVO getOrder(String orderSn) {
        LambdaQueryWrapper<OrderDO> queryWrapper = Wrappers.lambdaQuery(OrderDO.class)
                .eq(OrderDO::getOrderSn, orderSn);
        OrderDO orderDO = this.getBaseMapper().selectOne(queryWrapper);
        if (ObjectUtils.isEmpty(orderDO)){
            log.warn("未根据订单号:[{}]发现订单信息！", orderSn);
            throw new ClientException(OrderErrorEnum.ORDER_NOT_FOUNT);
        }
        List<OrderItemQueryVO> subOrderItem = getSubOrders(orderSn);
        Result<GameInfoVO> gameInfoResult;
        try{
            gameInfoResult = gameRemoteService.getGameInfoById(orderDO.getGameId());
             if (!gameInfoResult.isSuccess() || ObjectUtils.isEmpty(gameInfoResult.getData())){
                 throw new RemoteException(BaseErrorCode.REMOTE_ERROR);
             }
        }catch (Exception e){
            log.error("订单服务远程调用查询赛事服务失败!订单号:[{}],赛事id:[{}]", orderSn, orderDO.getGameId());
            throw e;
        }
        GameInfoVO gameInfo = gameInfoResult.getData();
        return OrderQueryVO.builder()
                .orderSn(orderDO.getOrderSn()).gameId(orderDO.getGameId())
                .title(gameInfo.getTitle()).playbillUrl(gameInfo.getPlaybillUrl())
                .totalAmount(new BigDecimal(orderDO.getTotalAmount()).divide(new BigDecimal("100"),2, RoundingMode.HALF_UP))
                .number(Convert.toLong(subOrderItem.size())).createTime(orderDO.getCreateTime())
                .build();
    }

    @Override
    public List<OrderItemQueryVO> getSubOrders(String orderSn) {
        LambdaQueryWrapper<OrderItemDO> queryWrapper = Wrappers.lambdaQuery(OrderItemDO.class)
                .eq(OrderItemDO::getOrderSn, orderSn);
        List<OrderItemDO> orderItemDOList = orderItemService.list(queryWrapper);
        return BeanUtil.convert(orderItemDOList, OrderItemQueryVO.class);
    }

    @Override
    public PageResponse<OrderQueryVO> pageQueryOrder(OrderPageQueryVO pageQueryVO) {
        LambdaQueryWrapper<OrderDO> queryWrapper = Wrappers.lambdaQuery(OrderDO.class)
                .eq(OrderDO::getUserId, pageQueryVO.getUserId());
        IPage<OrderDO> iPage = PageUtil.convert(pageQueryVO);
        IPage<OrderDO> pageResult = this.page(iPage, queryWrapper);
        return PageUtil.convert(pageResult, each -> this.getOrder(each.getOrderSn()));
    }

    /**
     * 取消订单并不会发起退款操作，取消订单是在创建订单且未支付过程中的行为 此时可直接修改订单状态
     * 真正退款操作是在用户支付后未消费前 进行退款
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(OrderCancelVO orderCancelVO) {
        String orderSn = orderCancelVO.getOrderSn();
        return this.updateOrderStatus(orderSn, OrderStatusEnum.CANCEL);
    }

    @Override
    public boolean updateOrderStatus(String orderSn, OrderStatusEnum orderStatusEnum) {
        LambdaQueryWrapper<OrderDO> lambdaQuery = Wrappers.lambdaQuery(OrderDO.class)
                .eq(OrderDO::getOrderSn, orderSn);
        OrderDO orderDO = this.getBaseMapper().selectOne(lambdaQuery);
        if (ObjectUtils.isEmpty(orderDO)){
            log.error("未查询到相关订单信息，订单号[{}]", orderSn);
            throw new ClientException(OrderErrorEnum.ORDER_NOT_FOUNT);
        }
        OrderDO newOrderDO = new OrderDO();
        newOrderDO.setOrderSn(orderDO.getOrderSn());
        newOrderDO.setStatus(orderStatusEnum.getStatus());
        LambdaUpdateWrapper<OrderDO> updateWrapper = Wrappers.lambdaUpdate(OrderDO.class)
                .eq(OrderDO::getOrderSn, orderDO.getOrderSn());
        this.getBaseMapper().update(newOrderDO, updateWrapper);

        OrderItemDO newOrderItemDO = new OrderItemDO();
        newOrderItemDO.setOrderSn(orderDO.getOrderSn());
        newOrderItemDO.setStatus(orderStatusEnum.getStatus());
        LambdaUpdateWrapper<OrderItemDO> updateItemWrapper = Wrappers.lambdaUpdate(OrderItemDO.class)
                .eq(OrderItemDO::getOrderSn, orderDO.getOrderSn());
        orderItemService.update(newOrderItemDO, updateItemWrapper);
        return true;
    }

    private boolean lockSeatV1(OrderCreateVO orderCreateVO) {
        Long arenaId = orderCreateVO.getArenaId();
        Long gameId = orderCreateVO.getGameId();
        int count = orderCreateVO.getOrderItemCreateVOList().size();
        return this.getBaseMapper().lockSeat(arenaId, gameId, count);
    }
}
