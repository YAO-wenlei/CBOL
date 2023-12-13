package org.cbol.database.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.cbol.database.handler.CbolMetaObjectHandler;
import org.springframework.context.annotation.Bean;

/**
 * @author yaowenlei
 * @date 2023年12月13日 7:55 下午
 */
public class MyBatisPlusAutoConfiguration {

    /**
     * 添加分页插件
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 自动填充字段
     */
    @Bean
    public CbolMetaObjectHandler cbolMetaObjectHandler() {
        return new CbolMetaObjectHandler();
    }
}
