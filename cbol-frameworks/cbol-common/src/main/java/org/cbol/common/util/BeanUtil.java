package org.cbol.common.util;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author yaowenlei
 * @date 2023年11月25日 3:01 下午
 * 对象复制工具类
 */
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class BeanUtil {
    protected static Mapper BASE_MAPPER;

    static {
        BASE_MAPPER = DozerBeanMapperBuilder.buildDefault();
    }

    /**
     * 拷贝对象属性
     * @author yaowenlei
     * @date 2023/11/25 3:21 下午
    **/
    public static <S, T> T convert(S source, T target) {
        Optional.ofNullable(source)
                .ifPresent(each -> BASE_MAPPER.map(each, target));
        return target;
    }

    /**
     * 拷贝对象属性
     * @author yaowenlei
     * @date 2023/11/25 3:21 下午
     **/
    public static <S, T> T convert(S source, Class<T> clazz) {
        return Optional.ofNullable(source)
                .map(each -> BASE_MAPPER.map(source, clazz))
                .orElse(null);
    }

    public static <S, T> List<T> convert(List<S> source, Class<T> clazz) {
        return Optional.ofNullable(source)
                .map(each -> {
                    ArrayList<T> list = new ArrayList<>(source.size());
                    each.stream().forEach(item -> {
                        list.add(BASE_MAPPER.map(item,clazz));
                    });
                    return list;
                }).orElse(null);
    }


}
