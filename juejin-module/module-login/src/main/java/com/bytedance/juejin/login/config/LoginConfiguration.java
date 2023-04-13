package com.bytedance.juejin.login.config;

import com.bytedance.juejin.login.LoginController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoginConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public LoginController loginController() {
        return new LoginController();
    }
}
