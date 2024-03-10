package org.cbol.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubRegisterVO {
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

}
