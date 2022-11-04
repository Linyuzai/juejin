package com.bytedance.juejin.basic.cache.memory;

import com.bytedance.juejin.basic.cache.Cache;
import com.bytedance.juejin.basic.cache.CacheProvider;
import org.springframework.stereotype.Component;

@Component
public class InMemoryCacheProvider implements CacheProvider {

    @Override
    public <T> Cache<T> get(Object key) {
        return new InMemoryCache<>();
    }
}
