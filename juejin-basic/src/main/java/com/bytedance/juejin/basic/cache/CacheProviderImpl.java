package com.bytedance.juejin.basic.cache;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 缓存提供者通过缓存适配器来返回各种缓存
 */
@Component
@AllArgsConstructor
public class CacheProviderImpl implements CacheProvider {

    /**
     * 所有的缓存适配器
     */
    private List<CacheAdapter> cacheAdapters;

    /**
     * 按顺序进行匹配
     */
    @Override
    public <T> Cache<T> get(Object key) {
        for (CacheAdapter adapter : cacheAdapters) {
            if (adapter.support(key)) {
                return adapter.adapt(key);
            }
        }
        return new NoCache<>();
    }

    /**
     * 当没有匹配到时返回无缓存
     */
    static class NoCache<T> implements Cache<T> {

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
}
