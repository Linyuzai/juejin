package com.bytedance.juejin.basic.domain;

public interface DomainEventPublisher {

    void publish(Object event);
}
