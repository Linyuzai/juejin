package com.bytedance.juejin.security.login;

import org.springframework.core.MethodParameter;

/**
 * 用于适配不同的参数类型
 */
public interface LoginArgumentAdapter {

    boolean support(MethodParameter parameter);

    Object adapt(MethodParameter parameter);
}
