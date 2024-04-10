package org.cbol.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.database.base.BaseDO;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_arena_seat")
public class ArenaSeatDO extends BaseDO {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 球馆id
     */
    private Long arenaId;

    /**
     * 赛程id
     */
    private Long gameId;

    /**
     * 座位数量
     */
    private Integer seat;

    /**
     * 剩余座位
     */
    private Integer remainingSeat;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 开售时间
     */
    private Date startSaleTime;

    /**
     * 结束销售时间
     */
    private Date stopSaleTime;
}
