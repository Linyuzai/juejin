package com.bytedance.juejin.basic.login;

import lombok.AllArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.List;

@AllArgsConstructor
public class LoginHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private List<LoginArgumentAdapter> argumentAdapters;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(Login.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        LoginArgumentAdapter adapter = getArgumentAdapter(parameter);
        if (adapter == null) {
            return null;
        }
        return adapter.adapt(parameter);
    }

    public LoginArgumentAdapter getArgumentAdapter(MethodParameter parameter) {
        for (LoginArgumentAdapter adapter : argumentAdapters) {
            if (adapter.support(parameter)) {
                return adapter;
            }
        }
        return null;
    }
}
