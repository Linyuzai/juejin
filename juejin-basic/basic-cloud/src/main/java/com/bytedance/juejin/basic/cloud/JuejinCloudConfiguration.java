package com.bytedance.juejin.basic.cloud;

import com.bytedance.juejin.basic.cloud.register.RouterRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微服务需要注入的组件
 */
@Configuration
public class JuejinCloudConfiguration {

    @Bean
    public RouterRegister routerRegister() {
        return new RouterRegister();
    }
}
