package com.bytedance.juejin.module.pin.config;

import com.bytedance.juejin.domain.like.LikeRepository;
import com.bytedance.juejin.domain.like.LikeService;
import com.bytedance.juejin.module.pin.domain.like.*;
import com.bytedance.juejin.module.pin.domain.like.LikeIdGeneratorImpl;
import com.bytedance.juejin.module.pin.infrastructure.like.mbp.MBPLikeRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 点赞配置
 */
@Configuration
public class DomainLikeConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public LikeController likeController() {
        return new LikeController();
    }

    @Bean
    @ConditionalOnMissingBean
    public LikeService likeService() {
        return new LikeService();
    }

    @Bean
    @ConditionalOnMissingBean
    public LikeApplicationService likeApplicationService() {
        return new LikeApplicationService();
    }

    @Bean
    @ConditionalOnMissingBean
    public LikeFacadeAdapter pinLikeFacadeAdapter() {
        return new LikeFacadeAdapterImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public LikeIdGenerator pinLikeIdGenerator() {
        return new LikeIdGeneratorImpl();
    }

    /**
     * MyBatis-Plus 配置
     */
    @Configuration
    public static class MyBatisPlusConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public LikeRepository pinLikeRepository() {
            return new MBPLikeRepository();
        }
    }
}
