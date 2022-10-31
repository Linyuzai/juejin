package com.bytedance.juejin.pin.config.core;

import com.bytedance.juejin.pin.domain.pin.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 沸点领域相关配置
 */
@Configuration
public class DomainPinConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public PinController pinController() {
        return new PinController();
    }

    @Bean
    @ConditionalOnMissingBean
    public PinService pinService() {
        return new PinService();
    }

    @Bean
    @ConditionalOnMissingBean
    public PinFacadeAdapter pinFacadeAdapter() {
        return new PinFacadeAdapterImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public PinSearcher pinSearcher() {
        return new PinSearcherImpl();
    }
}
