package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.domain.club.ClubRepository;
import com.bytedance.juejin.domain.club.ClubService;
import com.bytedance.juejin.pin.domain.club.*;
import com.bytedance.juejin.pin.infrastructure.club.mbp.MBPClubIdGenerator;
import com.bytedance.juejin.pin.infrastructure.club.mbp.MBPClubRepository;
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

    @Bean
    @ConditionalOnMissingBean
    public ClubApplicationService clubApplicationService() {
        return new ClubApplicationService();
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
            return new MBPClubRepository();
        }
    }
}
