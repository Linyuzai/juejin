package com.bytedance.juejin.basic.exception;

/**
 * 领域模型未找到的异常
 */
public class JuejinNotFoundException extends JuejinException {

    public JuejinNotFoundException(Class<?> type, String id) {
        super(type.getSimpleName() + " not found: " + id);
    }
}
