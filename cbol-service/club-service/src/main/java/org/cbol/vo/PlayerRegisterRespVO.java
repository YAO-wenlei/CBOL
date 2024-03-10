package org.cbol.vo;

import lombok.Data;

/**
 * 用户注册VO
 * @author yaowenlei
 */
@Data
public class PlayerRegisterRespVO {
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 头像地址
	 */
	private String avatar;
}
