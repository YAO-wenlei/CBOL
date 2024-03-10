package org.cbol.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArenaCreateRespVO {
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 球馆名称
	 */
	private String name;

	/**
	 * 球馆标志
	 */
	private String logoUrl;
}
