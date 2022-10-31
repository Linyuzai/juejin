package com.bytedance.juejin.basic;

import com.bytedance.juejin.basic.cloud.RouterRegister;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微服务需要而单体应用不需要注入的组件
 */
@Configuration
public class JuejinCloudConfiguration {

    @Bean
    public RouterRegister routerRegister() {
        return new RouterRegister();
    }
}
