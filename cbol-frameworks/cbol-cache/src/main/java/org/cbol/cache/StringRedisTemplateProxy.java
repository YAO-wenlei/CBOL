package org.cbol.cache;

import com.alibaba.fastjson2.JSON;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class StringRedisTemplateProxy implements DistributedCache{

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public <T> T get(String key, Class<T> clazz) {
        String value = stringRedisTemplate.opsForValue().get(key);
        if(String.class.isAssignableFrom(clazz)){
            return (T) value;
        }
        return JSON.parseObject(value, clazz);
    }

    @Override
    public <T> T get(String key, Class<T> clazz, Supplier<T> supplier) {
        T result = get(key, clazz);
        if (null != result){
            return result;
        }
        return supplier.get();
    }

    @Override
    public <T> T get(String key, Class<T> clazz, Supplier<T> supplier, Boolean putCache) {
        T reusult = get(key, clazz, supplier);
        if (Boolean.TRUE.equals(putCache)){
            put(key, reusult);
        }
        return reusult;
    }
    @Override
    public void put(String key, Object value) {
        String actual = value instanceof String ? (String) value : JSON.toJSONString(value);
        stringRedisTemplate.opsForValue().set(key, actual);
    }
    @Override
    public void put(String key, Object value, Long timeout, TimeUnit timeUnit) {
        String actual = value instanceof String ? (String) value : JSON.toJSONString(value);
        stringRedisTemplate.opsForValue().set(key, actual, timeout, timeUnit);
    }

    @Override
    public Boolean delete(String key) {
        return stringRedisTemplate.delete(key);
    }

    @Override
    public Long delete(Collection<String> keys) {
        return stringRedisTemplate.delete(keys);
    }

    @Override
    public Boolean hasKey(String key) {
        return stringRedisTemplate.hasKey(key);
    }

    @Override
    public Object getInstance() {
        return stringRedisTemplate;
    }
}
