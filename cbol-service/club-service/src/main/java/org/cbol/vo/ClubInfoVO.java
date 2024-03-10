package org.cbol.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubInfoVO {
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 标识
	 */
	private String code;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 简称
	 */
	private String simpleName;

	/**
	 * 标语
	 */
	private String slogan;

	/**
	 * 球队logo标识
	 */
	private String logoUrl;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 区域
	 */
	private String region;

	/**
	 * 手机
	 */
	private String phone;

	/**
	 * 负责人
	 */
	private String leader;

	/**
	 * 负责人手机号
	 */
	private String leaderPhone;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;

}
