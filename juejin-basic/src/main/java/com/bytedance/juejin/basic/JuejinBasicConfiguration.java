package com.bytedance.juejin.basic;

import org.springframework.context.annotation.Configuration;

/**
 * 单体应用和微服务都需要注入的组件
 */
@Configuration
public class JuejinBasicConfiguration {

    /*@Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }*/
}
