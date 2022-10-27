package com.bytedance.juejin.basic.exception;

public class JuejinIdRequiredException extends JuejinException {

    public JuejinIdRequiredException(Class<?> type) {
        super(type.getSimpleName() + " id required");
    }
}
