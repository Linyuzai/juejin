package com.bytedance.juejin.basic.domain.spring;

import com.bytedance.juejin.basic.domain.DomainEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;

@AllArgsConstructor
public class ApplicationDomainEventPublisher implements DomainEventPublisher {

    private ApplicationEventPublisher eventPublisher;

    @Override
    public void publish(Object event) {
        eventPublisher.publishEvent(event);
    }
}
