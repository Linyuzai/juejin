package com.bytedance.juejin.security.token;

import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.security.login.LoginContext;
import com.github.linyuzai.cloud.web.core.context.WebContext;
import com.github.linyuzai.cloud.web.core.intercept.ValueReturner;
import com.github.linyuzai.cloud.web.core.intercept.WebInterceptor;
import com.github.linyuzai.cloud.web.core.intercept.WebInterceptorChain;
import com.github.linyuzai.cloud.web.core.intercept.annotation.OnRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Order(0)
@OnRequest
@Component
public class TokenWebInterceptor implements WebInterceptor {

    @Autowired
    private TokenCodec tokenCodec;

    @Override
    public Object intercept(WebContext context, ValueReturner returner, WebInterceptorChain chain) {
        HttpServletRequest request = context.get(HttpServletRequest.class);
        String token = request.getHeader("Token");
        if (token == null) {
            throw new IllegalArgumentException("Token not found");
        }
        User user = tokenCodec.decode(token);
        LoginContext.setUser(user);
        return chain.next(context, returner);
    }
}
