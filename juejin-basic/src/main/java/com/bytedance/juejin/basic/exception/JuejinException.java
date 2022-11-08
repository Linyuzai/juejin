package com.bytedance.juejin.basic.exception;

/**
 * 异常基类
 */
public class JuejinException extends RuntimeException {

    public JuejinException(String message) {
        super(message);
    }

    public JuejinException(String message, Throwable cause) {
        super(message, cause);
    }
}
