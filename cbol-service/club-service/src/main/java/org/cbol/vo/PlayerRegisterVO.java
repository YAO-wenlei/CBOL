package org.cbol.vo;

import lombok.Data;

import java.util.Date;

/**
 * 球员注册VO
 * @author yaowenlei
 */
@Data
public class PlayerRegisterVO {
	/**
	 * 所属厂牌ID
	 */
	private Long clubId;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 身份证号
	 */
	private String idCard;
	/**
	 * 球衣号码
	 */
	private String playerNumber;
	/**
	 * 生日
	 */
	private Date birthday;
	/**
	 * 身高
	 */
	private double height;
	/**
	 * 体重
	 */
	private double weight;
	/**
	 * 位置
	 */
	private Integer position;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 住址
	 */
	private String address;
	/**
	 * 头像地址
	 */
	private String avatar;
}
