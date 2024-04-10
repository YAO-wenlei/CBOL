package org.cbol.order.vo;

import lombok.Data;
import org.cbol.common.page.PageRequest;

@Data
public class OrderPageQueryVO extends PageRequest {
    /**
     * 用户id
     */
    private Long userId;
}
