package org.cbol.common.page;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yaowenlei
 * @date 2023年11月25日 3:02 下午
 */
@Data
public class PageRequest implements Serializable {

    private Long current = 1L;

    private Long size = 10L;

}
