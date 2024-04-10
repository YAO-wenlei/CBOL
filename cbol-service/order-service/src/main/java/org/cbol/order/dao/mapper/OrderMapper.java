package org.cbol.order.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.cbol.order.dao.entity.OrderDO;

public interface OrderMapper extends BaseMapper<OrderDO> {
    boolean lockSeat(@Param("arenaId") Long arenaId,
                     @Param("gameId") Long gameId,
                     @Param("count") int count);
}
