package org.cbol.vo;

import lombok.Data;
import org.cbol.common.page.PageRequest;

@Data
public class PlayerPageQueryVO extends PageRequest {

	private Long id;

	/**
	 * 所属厂牌ID
	 */
	private Long clubId;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 球衣号码
	 */
	private String playerNumber;

	/**
	 * 位置
	 */
	private Integer position;

	/**
	 * 手机号
	 */
	private String phone;
}
