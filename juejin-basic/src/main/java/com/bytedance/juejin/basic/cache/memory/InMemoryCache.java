package com.bytedance.juejin.basic.cache.memory;

import com.bytedance.juejin.basic.cache.Cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 内存缓存
 *
 * @param <T>
 */
public class InMemoryCache<T> implements Cache<T> {

    private final Map<String, T> cache = new ConcurrentHashMap<>();

    @Override
    public void set(String id, T cache) {
        if (cache == null) {
            return;
        }
        this.cache.put(id, cache);
    }

    @Override
    public T get(String id) {
        return this.cache.get(id);
    }

    @Override
    public void remove(String id) {
        this.cache.remove(id);
    }
}
