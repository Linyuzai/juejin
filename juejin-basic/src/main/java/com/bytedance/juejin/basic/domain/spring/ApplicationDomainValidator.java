package com.bytedance.juejin.basic.domain.spring;

import com.bytedance.juejin.basic.domain.DomainValidator;
import lombok.AllArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

@AllArgsConstructor
public class ApplicationDomainValidator implements DomainValidator {

    private Validator validator;

    @Override
    public void validate(Object target) {
        Errors errors = getErrors();
        validator.validate(target, errors);
        for (ObjectError error : errors.getAllErrors()) {
        }
    }

    protected Errors getErrors() {
        return null;
    }
}
