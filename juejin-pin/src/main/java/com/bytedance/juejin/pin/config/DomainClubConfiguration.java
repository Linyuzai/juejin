package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.basic.config.mbp.ConditionalOnMyBatisPlus;
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

    @Bean
    @ConditionalOnMissingBean
    public ClubController clubController() {
        return new ClubController();
    }

    @Bean
    @ConditionalOnMissingBean
    public ClubService clubService() {
        return new ClubService();
    }

    @Bean
    @ConditionalOnMissingBean
    public ClubFacadeAdapter clubFacadeAdapter() {
        return new ClubFacadeAdapterImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public ClubSearcher clubSearcher() {
        return new ClubSearcherImpl();
    }

    @Configuration
    @ConditionalOnMyBatisPlus
    public static class MyBatisPlusConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public ClubIdGenerator clubIdGenerator() {
            return new MBPClubIdGenerator();
        }

        @Bean
        @ConditionalOnMissingBean
        public ClubRepository clubRepository() {
            return new MBPClubRepository();
        }
    }
}
