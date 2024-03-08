package org.cbol.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRespVO {

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 昵称
	 */
	private String name;

	/**
	 * 账号
	 */
	private String accountNumber;


	/**
	 * 头像地址
	 */
	private String avatar;


}
