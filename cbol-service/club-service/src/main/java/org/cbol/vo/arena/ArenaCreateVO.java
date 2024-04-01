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
public class ArenaCreateVO {

	/**
	 * 球馆名称
	 */
	private String name;

	/**
	 * 球馆地址
	 */
	private String address;

	/**
	 * 负责人
	 */
	private String leader;

	/**
	 * 负责人电话
	 */
	private String leaderPhone;

	/**
	 * 建造时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  // 将出参转化为指定格式
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //接收页面入参
	private Date builtTime;

	/**
	 * 最大可容纳
	 */
	private Integer maxSeat;

	/**
	 * 球馆标志
	 */
	private String logoUrl;

	/**
	 * 球馆介绍
	 */
	private String description;
}
