package com.bytedance.juejin.basic.domain.spring;

import com.bytedance.juejin.basic.domain.DomainContext;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;

@AllArgsConstructor
public class ApplicationDomainContext implements DomainContext {

    private ApplicationContext context;

    @Override
    public <T> T get(Class<T> type) {
        return context.getBean(type);
    }
}
