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
@TableName("t_game")
public class GameDO extends BaseDO {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 主队id
     */
    private Long homeTeamId;

    /**
     * 客队id
     */
    private Long guestTeamId;

    /**
     * 比赛球馆id
     */
    private Long arenaId;

    /**
     * 比赛开始时间
     */
    private Date startTime;

    /**
     * 比赛结束时间
     */
    private Date endTime;
}
