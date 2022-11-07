package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.basic.config.mbp.ConditionalOnMyBatisPlus;
import com.bytedance.juejin.pin.domain.pin.*;
import com.bytedance.juejin.pin.domain.pin.mbp.MBPPinIdGenerator;
import com.bytedance.juejin.pin.domain.pin.mbp.MBPPinRepository;
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
    public PinInstantiator pinInstantiator() {
        return new PinInstantiatorImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public PinSearcher pinSearcher() {
        return new PinSearcherImpl();
    }

    @Configuration
    @ConditionalOnMyBatisPlus
    public static class MyBatisPlusConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public PinIdGenerator pinIdGenerator() {
            return new MBPPinIdGenerator();
        }

        @Bean
        @ConditionalOnMissingBean
        public PinRepository pinRepository() {
            return new MBPPinRepository<>();
        }
    }
}
