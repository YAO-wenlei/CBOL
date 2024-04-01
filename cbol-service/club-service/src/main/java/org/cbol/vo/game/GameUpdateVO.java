package org.cbol.vo.game;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.vo.arena.ArenaSeatUpdateVO;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameUpdateVO {

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

    private ArenaSeatUpdateVO arenaSeat;
}
