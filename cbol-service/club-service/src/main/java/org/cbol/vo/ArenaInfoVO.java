package org.cbol.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArenaInfoVO {
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 球馆名称
	 */
	private String name;

	/**
	 * 球馆地址
	 */
	private String address;

	/**
	 * 最大可容纳
	 */
	private Integer maxSeat;

	/**
	 * 球馆标志
	 */
	private String logoUrl;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

}
