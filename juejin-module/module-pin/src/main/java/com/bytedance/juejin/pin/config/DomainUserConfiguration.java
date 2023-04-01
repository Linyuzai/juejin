package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.pin.domain.user.*;
import com.bytedance.juejin.pin.domain.user.remote.RemoteUserRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用户领域相关配置
 */
@Configuration
public class DomainUserConfiguration {

    /**
     * 用户模型与视图的转换适配器
     */
    @Bean
    @ConditionalOnMissingBean
    public UserFacadeAdapter pinUserFacadeAdapter() {
        return new UserFacadeAdapterImpl();
    }

    /**
     * 用户实例化器
     */
    @Bean
    @ConditionalOnMissingBean
    public UserInstantiator pinUserInstantiator() {
        return new UserInstantiatorImpl();
    }

    /**
     * 远程用户存储
     */
    @Bean
    @ConditionalOnMissingBean
    public UserRepository pinUserRepository() {
        return new RemoteUserRepository();
    }
}
