package com.bytedance.juejin.basic.autoconfigure.feign;

import com.bytedance.juejin.basic.rpc.user.feign.FeignUserRepository;
import com.bytedance.juejin.domain.user.UserRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.bytedance.juejin.basic.rpc.*.feign")
public class FeignAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public UserRepository userRepository() {
        return new FeignUserRepository();
    }
}
