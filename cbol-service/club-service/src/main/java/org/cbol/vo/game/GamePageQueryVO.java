package org.cbol.vo.game;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.common.page.PageRequest;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GamePageQueryVO extends PageRequest {
    /**
     * 球馆ID
     */
    private Long areanId;

    /**
     * 厂牌ID
     */
    private Long clubId;
    /**
     * 比赛标题
     */
    private String title;
    /**
     * 海报地址
     */
    private String playbillUrl;

    /**
     * 开始时间
     */
    private Date startTime;
}
