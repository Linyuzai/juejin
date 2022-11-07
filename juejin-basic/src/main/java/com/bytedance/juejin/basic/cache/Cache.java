package com.bytedance.juejin.basic.cache;

/**
 * 缓存
 */
public interface Cache<T> {

    /**
     * 设置缓存
     */
    void set(String id, T cache);

    /**
     * 获得缓存
     */
    T get(String id);

    /**
     * 清除缓存
     */
    void remove(String id);
}
