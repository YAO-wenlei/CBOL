package org.cbol.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.cbol.order.dao.entity.OrderItemDO;
import org.cbol.order.dao.mapper.OrderItemMapper;
import org.cbol.order.service.OrderItemService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemDO> implements OrderItemService {
}
