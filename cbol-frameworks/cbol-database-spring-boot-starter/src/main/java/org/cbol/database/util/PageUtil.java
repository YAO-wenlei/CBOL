package org.cbol.database.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.cbol.common.page.PageRequest;
import org.cbol.common.page.PageResponse;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分页工具类
 * @author yaowenlei
 * @date 2023年12月15日 10:53 下午
 */
public class PageUtil {

    public static IPage convert(PageRequest request) {
        return convert(request.getCurrent(), request.getSize());
    }

    public static IPage convert(Long current, Long size) {
        return new Page(current, size);
    }

    public static PageResponse convert(IPage page) {
        return PageResponse.builder()
                .current(page.getCurrent())
                .size(page.getSize())
                .total(page.getTotal())
                .records(page.getRecords())
                .build();
    }

    public static <SOURCE, TARGET> PageResponse<TARGET> convert(IPage<SOURCE> iPage, Function<SOURCE, TARGET> mapper) {
        List<TARGET> collect = iPage.getRecords().stream()
                .map(mapper)
                .collect(Collectors.toList());
        return PageResponse.<TARGET>builder()
                .current(iPage.getCurrent())
                .size(iPage.getSize())
                .total(iPage.getTotal())
                .records(collect).build();
    }

}
