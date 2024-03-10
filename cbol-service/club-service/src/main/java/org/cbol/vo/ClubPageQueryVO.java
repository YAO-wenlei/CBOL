package org.cbol.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cbol.common.page.PageRequest;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubPageQueryVO extends PageRequest {
	/**
	 * 厂牌id
	 */
	private Long id;
	/**
	 * 厂牌名称
	 */
	private String name;
}
