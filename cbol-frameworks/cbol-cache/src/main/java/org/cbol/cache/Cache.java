package org.cbol.cache;


import java.util.Collection;

public interface Cache {

    /**
     * 获取缓存
     */
    <T> T get(String key, Class<T> clazz);
    /**
     * 刚入缓存
     */
    void put(String key, Object value);
    /**
     * 删除key
     * @param key key值
     * @return 是否删除成功
     */
    Boolean delete(String key);

    /**
     * 批量删除
     * @param keys key
     * @return 删除数量
     */
    Long delete(Collection<String> keys);

    /**
     * 是否存在某个key
     * @param key
     * @return
     */
    Boolean hasKey(String key);

    /**
     * 获取缓存实例
     */
    Object getInstance();

}
