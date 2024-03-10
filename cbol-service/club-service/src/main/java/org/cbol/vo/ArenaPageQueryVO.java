package org.cbol.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.common.page.PageRequest;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArenaPageQueryVO extends PageRequest {
	/**
	 * 主键
	 */
	private Long id;

	/**
	 * 球馆名称
	 */
	private String name;
}
