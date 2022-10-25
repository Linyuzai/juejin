package com.bytedance.juejin.basic.domain;

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
        if (validator == null) {
            return;
        }
        validator.validate(this);
    }

    protected void initDefaultValue() {

    }

    public abstract T doBuild();
}
