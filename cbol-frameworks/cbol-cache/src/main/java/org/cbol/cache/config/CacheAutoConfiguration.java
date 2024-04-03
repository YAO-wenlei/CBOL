package org.cbol.cache.config;

import org.cbol.cache.StringRedisTemplateProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;

public class CacheAutoConfiguration {

    @Bean
    public StringRedisTemplateProxy stringRedisTemplateProxy(StringRedisTemplate stringRedisTemplate) {
        return new StringRedisTemplateProxy(stringRedisTemplate);
    }

}
