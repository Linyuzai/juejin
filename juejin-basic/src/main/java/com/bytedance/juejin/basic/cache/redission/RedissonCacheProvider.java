package com.bytedance.juejin.basic.cache.redission;

import com.bytedance.juejin.basic.cache.Cache;
import com.bytedance.juejin.basic.cache.CacheProvider;

public class RedissonCacheProvider implements CacheProvider {

    @Override
    public <T> Cache<T> get(Object key) {
        return new RedissonCache<>();
    }
}
