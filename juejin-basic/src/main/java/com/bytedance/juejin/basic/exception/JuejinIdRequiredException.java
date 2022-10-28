package com.bytedance.juejin.basic.exception;

public class JuejinIdRequiredException extends JuejinRequiredException {

    public JuejinIdRequiredException(Class<?> type) {
        super(type.getSimpleName() + " id");
    }
}
