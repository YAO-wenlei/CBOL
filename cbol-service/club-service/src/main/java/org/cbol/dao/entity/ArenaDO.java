package org.cbol.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.database.base.BaseDO;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_arena")
public class ArenaDO extends BaseDO {
	/**
	 * 主键
	 */
	@TableField()
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;

	/**
	 * 球馆名称
	 */
	private String name;

	/**
	 * 球馆地址
	 */
	private String address;

	/**
	 * 负责人
	 */
	private String leader;

	/**
	 * 负责人电话
	 */
	private String leaderPhone;

	/**
	 * 建造时间
	 */
	private Date builtTime;

	/**
	 * 最大可容纳
	 */
	private Integer maxSeat;

	/**
	 * 球馆标志
	 */
	private String logoUrl;

	/**
	 * 球馆介绍
	 */
	private String description;
}
