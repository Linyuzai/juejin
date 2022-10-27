package com.bytedance.juejin.basic.exception;

public class JuejinNotFoundException extends JuejinException {

    public JuejinNotFoundException(Class<?> type, String id) {
        super(type.getSimpleName() + " not found: " + id);
    }
}
