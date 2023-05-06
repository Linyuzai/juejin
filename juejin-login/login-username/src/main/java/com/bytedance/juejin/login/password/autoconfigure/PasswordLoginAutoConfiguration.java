package com.bytedance.juejin.login.password.autoconfigure;

import com.bytedance.juejin.login.password.PasswordLoginController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordLoginAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public PasswordLoginController passwordLoginController() {
        return new PasswordLoginController();
    }
}
