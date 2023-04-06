package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.domain.pin.PinRepository;
import com.bytedance.juejin.domain.pin.PinService;
import com.bytedance.juejin.pin.domain.pin.*;
import com.bytedance.juejin.pin.infrastructure.pin.mbp.MBPPinIdGenerator;
import com.bytedance.juejin.pin.infrastructure.pin.mbp.MBPPinRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 沸点领域相关配置
 */
@Configuration
public class DomainPinConfiguration {

    /**
     * 沸点 Controller
     */
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

    /**
     * 沸点 Service
     */
    @Bean
    @ConditionalOnMissingBean
    public PinApplicationService pinApplicationService() {
        return new PinApplicationService();
    }

    /**
     * 沸点模型与视图的转换适配器
     */
    @Bean
    @ConditionalOnMissingBean
    public PinFacadeAdapter pinFacadeAdapter() {
        return new PinFacadeAdapterImpl();
    }

    /**
     * 沸点搜索器
     */
    @Bean
    @ConditionalOnMissingBean
    public PinSearcher pinSearcher() {
        return new PinSearcherImpl();
    }

    /**
     * 沸点 MyBatis-Plus 配置
     */
    @Configuration
    public static class MyBatisPlusConfiguration {

        /**
         * 沸点 id 生成器
         */
        @Bean
        @ConditionalOnMissingBean
        public PinIdGenerator pinIdGenerator() {
            return new MBPPinIdGenerator();
        }

        /**
         * 基于 MyBatis-Plus 的沸点存储
         */
        @Bean
        @ConditionalOnMissingBean
        public PinRepository pinRepository() {
            return new MBPPinRepository();
        }
    }
}
