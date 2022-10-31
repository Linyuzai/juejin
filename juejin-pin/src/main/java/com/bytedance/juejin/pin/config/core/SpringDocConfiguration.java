package com.bytedance.juejin.pin.config.core;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Doc 相关配置
 */
@Configuration
public class SpringDocConfiguration {

    @Bean
    public GroupedOpenApi pinApi() {
        return GroupedOpenApi.builder()
                .group("沸点")
                .packagesToScan("com.bytedance.juejin.pin")
                .build();
    }
}
