package com.bytedance.juejin.basic.login;

import org.springframework.core.MethodParameter;

public interface LoginArgumentAdapter {

    boolean support(MethodParameter parameter);

    Object adapt(MethodParameter parameter);
}
