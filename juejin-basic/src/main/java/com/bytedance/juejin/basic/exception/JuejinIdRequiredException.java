package com.bytedance.juejin.basic.exception;

/**
 * id 为 null 的异常
 */
public class JuejinIdRequiredException extends JuejinRequiredException {

    public JuejinIdRequiredException(Class<?> type) {
        super(type.getSimpleName() + " id");
    }
}
