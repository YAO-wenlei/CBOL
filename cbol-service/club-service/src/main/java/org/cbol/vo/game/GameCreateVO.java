package org.cbol.vo.game;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.vo.arena.ArenaSeatCreateVO;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameCreateVO {
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 将出参转化为指定格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //接收页面入参
    private Date startTime;

    /**
     * 比赛结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 将出参转化为指定格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //接收页面入参
    private Date endTime;

    private ArenaSeatCreateVO arenaSeat;


}
