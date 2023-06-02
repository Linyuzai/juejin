package com.bytedance.juejin.module.pin.config;

import com.bytedance.juejin.domain.pin.PinRepository;
import com.bytedance.juejin.domain.pin.PinService;
import com.bytedance.juejin.module.pin.domain.pin.*;
import com.bytedance.juejin.module.pin.infrastructure.pin.mbp.MBPPinRepository;
import com.github.linyuzai.domain.mbp.MBPDomainIdGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 沸点配置
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
    public PinApplicationService pinApplicationService() {
        return new PinApplicationService();
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

    /**
     * MyBatis-Plus 配置
     */
    @Configuration
    public static class MyBatisPlusConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public PinIdGenerator pinIdGenerator() {
            return MBPDomainIdGenerator.create(PinIdGenerator.class);
        }

        @Bean
        @ConditionalOnMissingBean
        public PinRepository pinRepository() {
            return new MBPPinRepository();
        }
    }
}
