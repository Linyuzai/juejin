package com.bytedance.juejin.basic.cache.redission;

import com.bytedance.juejin.basic.cache.Cache;

/**
 * 基于 redisson 的缓存
 *
 * @param <T>
 */
public class RedissonCache<T> implements Cache<T> {

    @Override
    public void set(String id, T cache) {

    }

    @Override
    public T get(String id) {
        return null;
    }

    @Override
    public void remove(String id) {

    }
}
