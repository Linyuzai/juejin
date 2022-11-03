package com.bytedance.juejin.basic.domain.spring;

import com.bytedance.juejin.basic.domain.DomainValidator;
import lombok.AllArgsConstructor;
import org.springframework.validation.*;

import java.util.Objects;

@AllArgsConstructor
public class ApplicationDomainValidator implements DomainValidator {

    private Validator validator;

    @Override
    public void validate(Object target) {
        BindingResult bindingResult = getBindingResult(target);
        validator.validate(target, bindingResult);
        onBindingResult(target, bindingResult);
    }

    protected BindingResult getBindingResult(Object target) {
        return new DirectFieldBindingResult(target, target.getClass().getSimpleName());
    }

    protected void onBindingResult(Object target, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            FieldError error = Objects.requireNonNull(bindingResult.getFieldError());
            String s = target.getClass().getName() + "#" + error.getField();
            throw new IllegalArgumentException(s + ", " + error.getDefaultMessage());
        }
    }
}
