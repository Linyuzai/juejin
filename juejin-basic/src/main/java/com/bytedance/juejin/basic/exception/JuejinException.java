package com.bytedance.juejin.basic.exception;

public class JuejinException extends RuntimeException {

    public JuejinException(String message) {
        super(message);
    }

    public JuejinException(String message, Throwable cause) {
        super(message, cause);
    }
}
