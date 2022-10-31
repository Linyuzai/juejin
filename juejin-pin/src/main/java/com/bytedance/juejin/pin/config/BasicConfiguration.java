package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.pin.config.UserLoginArgumentAdapter;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * juejin-basic 模块相关配置
 */
@Configuration
public class BasicConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public UserLoginArgumentAdapter userLoginArgumentAdapter() {
        return new UserLoginArgumentAdapter();
    }
}
