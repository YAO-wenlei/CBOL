package org.cbol.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.database.base.BaseDO;

import java.util.Date;

/**
 * 运动员信息表
 * @author yaowenlei
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_player")
public class PlayerDO extends BaseDO {
	/**
	 * 主键
	 */
	@TableId(value = "id",type = IdType.AUTO)
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
	private Double height;
	/**
	 * 体重
	 */
	private Double weight;
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
