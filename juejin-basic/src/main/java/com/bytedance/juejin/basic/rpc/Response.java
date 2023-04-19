package com.bytedance.juejin.basic.rpc;

import lombok.Data;

@Data
public class Response<T> {

    private boolean success;

    private String code;

    private String message;

    private T object;
}