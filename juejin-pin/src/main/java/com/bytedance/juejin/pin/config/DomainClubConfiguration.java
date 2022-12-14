package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.basic.autoconfigure.mbp.ConditionalOnMyBatisPlus;
import com.bytedance.juejin.pin.domain.club.*;
import com.bytedance.juejin.pin.domain.club.mbp.MBPClubIdGenerator;
import com.bytedance.juejin.pin.domain.club.mbp.MBPClubRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 圈子领域相关配置
 */
@Configuration
public class DomainClubConfiguration {

    /**
     * 沸点圈子 Controller
     */
    @Bean
    @ConditionalOnMissingBean
    public ClubController pinClubController() {
        return new ClubController();
    }

    /**
     * 沸点圈子 Service
     */
    @Bean
    @ConditionalOnMissingBean
    public ClubService pinClubService() {
        return new ClubService();
    }

    /**
     * 沸点圈子模型与视图的转换适配器
     */
    @Bean
    @ConditionalOnMissingBean
    public ClubFacadeAdapter pinClubFacadeAdapter() {
        return new ClubFacadeAdapterImpl();
    }

    /**
     * 沸点圈子实例化器
     */
    @Bean
    @ConditionalOnMissingBean
    public ClubInstantiator pinClubInstantiator() {
        return new ClubInstantiatorImpl();
    }

    /**
     * 沸点圈子搜索器
     */
    @Bean
    @ConditionalOnMissingBean
    public ClubSearcher pinClubSearcher() {
        return new ClubSearcherImpl();
    }

    /**
     * 沸点圈子 MyBatis-Plus 配置
     */
    @Configuration
    @ConditionalOnMyBatisPlus
    public static class MyBatisPlusConfiguration {

        /**
         * 沸点圈子 id 生成器
         */
        @Bean
        @ConditionalOnMissingBean
        public ClubIdGenerator pinClubIdGenerator() {
            return new MBPClubIdGenerator();
        }

        /**
         * 基于 MyBatis-Plus 的沸点圈子存储
         */
        @Bean
        @ConditionalOnMissingBean
        public ClubRepository pinClubRepository() {
            return new MBPClubRepository<>();
        }
    }
}
