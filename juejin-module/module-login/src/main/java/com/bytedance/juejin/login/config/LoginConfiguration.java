package com.bytedance.juejin.login.config;

import com.bytedance.juejin.login.LoginController;
import com.github.linyuzai.cloud.web.core.intercept.annotation.BreakIntercept;
import com.github.linyuzai.cloud.web.core.intercept.annotation.OnRequest;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class LoginConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public LoginController loginController() {
        return new LoginController();
    }

    @Order(-1)
    @BreakIntercept
    @OnRequest
    public boolean nonIntercept(HttpServletRequest request) {
       return request.getRequestURI().equals("/login");
    }
}
