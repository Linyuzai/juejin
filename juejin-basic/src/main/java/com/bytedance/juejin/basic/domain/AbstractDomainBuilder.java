package com.bytedance.juejin.basic.domain;

import java.util.Objects;

@SuppressWarnings("unchecked")
public abstract class AbstractDomainBuilder<T extends DomainObject, B> implements DomainBuilder<T> {

    protected DomainValidator validator;

    public B validator(DomainValidator validator) {
        this.validator = validator;
        return (B) this;
    }

    @Override
    public T build() {
        initDefaultValue();
        validate();
        return doBuild();
    }

    protected void validate() {
        Objects.requireNonNull(validator).validate(this);
    }

    protected void initDefaultValue() {

    }

    protected abstract T doBuild();
}
