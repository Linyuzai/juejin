package com.bytedance.juejin.basic;

import com.bytedance.juejin.basic.cloud.RouterRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JuejinCloudConfiguration {

    @Bean
    public RouterRegister routerRegister() {
        return new RouterRegister();
    }
}
