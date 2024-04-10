package org.cbol.order.remote.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInfoVO {
    /**
     * 主键
     */
    private Long id;
    /**
     * 比赛标题
     */
    private String title;
    /**
     * 海报地址
     */
    private String playbillUrl;
    /**
     * 主队id
     */
    private Long homeTeamId;
    /**
     * 主队名称
     */
    private String homeTeamName;
    /**
     * 主队logo
     */
    private String homeTeamLogo;

    /**
     * 客队id
     */
    private Long guestTeamId;
    /**
     * 客队名称
     */
    private String guestTeamName;
    /**
     * 客队logo
     */
    private String guestTeamLogo;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 将出参转化为指定格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //接收页面入参
    private Date startTime;
    /**
     * 比赛结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 将出参转化为指定格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //接收页面入参
    private Date endTime;
    /**
     * 开售时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 将出参转化为指定格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //接收页面入参
    private Date startSaleTime;
    /**
     * 结束销售时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 将出参转化为指定格式
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //接收页面入参
    private Date stopSaleTime;
}
