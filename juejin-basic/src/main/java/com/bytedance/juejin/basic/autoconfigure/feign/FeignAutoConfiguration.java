package com.bytedance.juejin.basic.autoconfigure.feign;

import com.bytedance.juejin.basic.rpc.api.user.UserApi;
import com.bytedance.juejin.basic.rpc.feign.user.FeignUserApi;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.loadbalancer.config.LoadBalancerAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnFeign
@AutoConfigureBefore(LoadBalancerAutoConfiguration.class)
@EnableConfigurationProperties(FeignProperties.class)
@EnableFeignClients(basePackages = "com.bytedance.juejin.basic.rpc.feign")
public class FeignAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public UserApi userApi() {
        return new FeignUserApi();
    }
}
