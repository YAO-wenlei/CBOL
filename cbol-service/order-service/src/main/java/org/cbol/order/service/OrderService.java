package org.cbol.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.cbol.common.page.PageResponse;
import org.cbol.order.dao.entity.OrderDO;
import org.cbol.order.enums.OrderStatusEnum;
import org.cbol.order.vo.*;

import java.util.List;

public interface OrderService extends IService<OrderDO> {
    String createOrder(OrderCreateVO orderCreateVO);

    OrderQueryVO getOrder(String orderSn);

    public List<OrderItemQueryVO> getSubOrders(String orderSn);

    PageResponse<OrderQueryVO> pageQueryOrder(OrderPageQueryVO pageQueryVO);

    boolean cancel(OrderCancelVO orderCancelVO);

    boolean updateOrderStatus(String orderSn, OrderStatusEnum orderStatusEnum);
}
