package com.bytedance.juejin.basic.domain;

public interface DomainContext {

    <T> T get(Class<T> type);
}
