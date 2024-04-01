package org.cbol.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInfoDTO {
    /**
     * 主键
     */
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
     * 比赛球馆名称
     */
    private String arenaName;
    /**
     * 比赛开始时间
     */
    private Date startTime;
    /**
     * 比赛结束时间
     */
    private Date endTime;
    /**
     * 开售时间
     */
    private Date startSaleTime;
    /**
     * 结束销售时间
     */
    private Date stopSaleTime;
}
