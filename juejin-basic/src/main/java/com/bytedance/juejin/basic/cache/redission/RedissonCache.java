package com.bytedance.juejin.basic.cache.redission;

import com.bytedance.juejin.basic.cache.Cache;

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
