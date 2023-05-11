package com.bytedance.juejin.basic.cloud;

import com.bytedance.juejin.basic.cloud.register.MetadataRegister;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 微服务需要注入的组件
 */
@Configuration
public class JuejinCloudConfiguration {

    @Bean
    public MetadataRegister metadataRegister(List<GroupedOpenApi> groupedOpenApis) {
        return new MetadataRegister(groupedOpenApis);
    }
}
