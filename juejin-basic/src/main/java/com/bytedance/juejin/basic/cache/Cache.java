package com.bytedance.juejin.basic.cache;

public interface Cache<T> {

    void set(String id, T cache);

    T get(String id);

    void remove(String id);
}
