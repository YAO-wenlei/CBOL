package org.cbol.vo.arena;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArenaSeatUpdateVO {
    /**
     * 座位数量
     */
    private Integer seat;
    /**
     * 价格
     */
    private Double price;
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
