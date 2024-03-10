package org.cbol.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.cbol.database.base.BaseDO;

/**
 *  EqualsAndHashCode注解作用为在生成equals方法时，如果存在继承超类字段，是否
 *  将超类字段也作为比较信息 callSuper为true则比较
 * @author yaowenlei
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_club")
public class ClubDO extends BaseDO {
	/**
	 * 主键
	 */
	@TableId(value = "id",type = IdType.AUTO)
	@TableField(value = "id")
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
}
