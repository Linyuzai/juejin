package com.bytedance.juejin.basic.domain;

/**
 * 领域 id 生成器
 *
 * @param <T>
 */
public interface DomainIdGenerator<T extends DomainObject> {

    String generateId(Class<T> domainClass);
}
