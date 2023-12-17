package org.cbol.common.page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author yaowenlei
 * @date 2023年11月25日 9:39 下午
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> implements Serializable {
    /**
     * 当前页
     */
    private Long current;

    /**
     * 当前页大小
     */
    private Long size;

    /**
     * 总数
     */
    private Long total;

    /**
     * 查询数据
     */
    private List<T> records = Collections.emptyList();;


}
