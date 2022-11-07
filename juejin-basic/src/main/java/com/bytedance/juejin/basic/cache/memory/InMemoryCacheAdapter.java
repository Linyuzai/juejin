package com.bytedance.juejin.basic.cache.memory;

import com.bytedance.juejin.basic.cache.Cache;
import com.bytedance.juejin.basic.cache.CacheAdapter;
import org.springframework.stereotype.Component;

/**
 * 内存缓存适配器
 */
@Component
public class InMemoryCacheAdapter implements CacheAdapter {

    /**
     * 全部支持
     */
    @Override
    public boolean support(Object key) {
        return true;
    }

    /**
     * 返回内存缓存实现
     */
    @Override
    public <T> Cache<T> adapt(Object key) {
        return new InMemoryCache<>();
    }
}
