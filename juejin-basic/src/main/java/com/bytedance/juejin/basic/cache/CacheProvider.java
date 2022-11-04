package com.bytedance.juejin.basic.cache;

public interface CacheProvider {

    <T> Cache<T> get(Object key);
}
