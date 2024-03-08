package org.cbol.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.common.page.PageRequest;

import java.util.Date;

/**
 * 用户分页查询基础VO对象
 * @author yaowenlei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPageQueryVO extends PageRequest {
	/**
	 * 用户id
	 */
	private Integer id;
	/**
	 * 用户昵称
	 */
	private String name;
	/**
	 * 用户手机号
	 */
	private String phone;
	/**
	 * 用户年龄
	 */
	private Integer age;
	/**
	 * 用户性别
	 */
	private Integer sex;
	/**
	 * 用户出生日期
	 */
	private Date birthday;
}
