package com.bytedance.juejin.basic.domain;

import javax.validation.constraints.NotNull;

@SuppressWarnings("unchecked")
public abstract class ContextDomainBuilder<T extends DomainObject, B> extends AbstractDomainBuilder<T, B> {

    @NotNull
    protected DomainContext context;

    public B context(DomainContext context) {
        this.context = context;
        return (B) this;
    }
}
