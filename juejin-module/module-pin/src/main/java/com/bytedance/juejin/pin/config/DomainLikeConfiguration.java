package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.domain.like.LikeRepository;
import com.bytedance.juejin.domain.like.LikeService;
import com.bytedance.juejin.pin.domain.like.*;
import com.bytedance.juejin.pin.domain.like.LikeIdGeneratorImpl;
import com.bytedance.juejin.pin.infrastructure.like.mbp.MBPLikeRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 点赞领域相关配置
 */
@Configuration
public class DomainLikeConfiguration {

    /**
     * 点赞 Controller
     */
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

    /**
     * 点赞 Service
     */
    @Bean
    @ConditionalOnMissingBean
    public LikeApplicationService likeApplicationService() {
        return new LikeApplicationService();
    }

    /**
     * 点赞模型与视图的转换适配器
     */
    @Bean
    @ConditionalOnMissingBean
    public LikeFacadeAdapter pinLikeFacadeAdapter() {
        return new LikeFacadeAdapterImpl();
    }

    /**
     * 点赞 id 生成器
     */
    @Bean
    @ConditionalOnMissingBean
    public LikeIdGenerator pinLikeIdGenerator() {
        return new LikeIdGeneratorImpl();
    }

    /**
     * 点赞 MyBatis-Plus 配置
     */
    @Configuration
    public static class MyBatisPlusConfiguration {

        /**
         * 基于 MyBatis-Plus 的点赞存储
         */
        @Bean
        @ConditionalOnMissingBean
        public LikeRepository pinLikeRepository() {
            return new MBPLikeRepository();
        }
    }
}
