package org.cbol.cache;

import org.junit.Before;
import org.junit.Test;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DistributedCacheTest {
    private DistributedCache distributedCache;

    @Before
    public void init() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setHostName("host");
        connectionFactory.setPort(3306);
        connectionFactory.setPassword("password");

        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(connectionFactory);
        //非spring环境使用stringRedisTemplate 需要调用afterPropertiesSet()方法
        stringRedisTemplate.afterPropertiesSet();
        distributedCache = new StringRedisTemplateProxy(stringRedisTemplate);
    }

    @Test
    public void testPutString() {
        distributedCache.put("zhangsan","你好");
    }

    @Test
    public void testPutStringAndExpire() {
        distributedCache.put("A", "B", 100L, TimeUnit.SECONDS);
    }

    @Test
    public void testPutObject() {
        Course course = new Course("数学");
        Student student = new Student("张三", 20, course);
        distributedCache.put("student", student);
    }

    @Test
    public void testPutObjectAndExpire() {
        Course course = new Course("数学");
        Student student = new Student("张三", 20, course);
        distributedCache.put("student", student,100L, TimeUnit.SECONDS);
    }

    @Test
    public void testGetString() {
        String s = distributedCache.get("zhangsan", String.class);
        System.out.println(s);
    }

    @Test
    public void testGetObject() {
        Student student = distributedCache.get("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testGetStringIsNull() {
        String s = distributedCache.get("liming", String.class, () -> "a");
        System.out.println(s);
    }

    @Test
    public void testGetStringNotNull() {
        String s = distributedCache.get("zhangsan", String.class, () -> "a");
        System.out.println(s);
    }

    @Test
    public void testHasKey() {
        System.out.println(distributedCache.hasKey("zhangsan"));
    }

    @Test
    public void testDelete() {
        Boolean delete = distributedCache.delete("zhangsan");
        System.out.println(delete);
    }

    @Test
    public void testDeleteKeys() {
        List<String> list = Arrays.asList("a", "b", "c");
        Long delete = distributedCache.delete(list);
        System.out.println(delete);
    }

}
