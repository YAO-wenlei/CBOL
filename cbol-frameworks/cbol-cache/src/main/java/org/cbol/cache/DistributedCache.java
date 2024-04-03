package org.cbol.cache;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public interface DistributedCache extends Cache {

    <T> T get(String key, Class<T> clazz, Supplier<T> supplier);

    <T> T get(String key, Class<T> clazz, Supplier<T> supplier, Boolean putCache);

    void put(String key, Object value, Long timeout, TimeUnit timeUnit);


}
