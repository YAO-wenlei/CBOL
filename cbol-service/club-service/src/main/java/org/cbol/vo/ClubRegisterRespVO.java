package org.cbol.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubRegisterRespVO {
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
}
