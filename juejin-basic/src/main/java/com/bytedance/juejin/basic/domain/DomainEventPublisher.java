package com.bytedance.juejin.basic.domain;

/**
 * 领域事件发布器
 */
public interface DomainEventPublisher {

    void publish(Object event);
}
