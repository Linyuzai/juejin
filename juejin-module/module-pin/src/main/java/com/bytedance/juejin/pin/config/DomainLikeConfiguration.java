package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.basic.autoconfigure.mbp.ConditionalOnMyBatisPlus;
import com.bytedance.juejin.pin.domain.like.*;
import com.bytedance.juejin.pin.domain.like.mbp.MBPLikeIdGenerator;
import com.bytedance.juejin.pin.domain.like.mbp.MBPLikeRepository;
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
    public LikeController pinLikeController() {
        return new LikeController();
    }

    /**
     * 点赞 Service
     */
    @Bean
    @ConditionalOnMissingBean
    public LikeService pinLikeService() {
        return new LikeService();
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
     * 点赞实例化器
     */
    @Bean
    @ConditionalOnMissingBean
    public LikeInstantiator likeInstantiator() {
        return new LikeInstantiatorImpl();
    }

    /**
     * 点赞 MyBatis-Plus 配置
     */
    @Configuration
    @ConditionalOnMyBatisPlus
    public static class MyBatisPlusConfiguration {

        /**
         * 点赞 id 生成器
         */
        @Bean
        @ConditionalOnMissingBean
        public LikeIdGenerator pinLikeIdGenerator() {
            return new MBPLikeIdGenerator();
        }

        /**
         * 基于 MyBatis-Plus 的点赞存储
         */
        @Bean
        @ConditionalOnMissingBean
        public LikeRepository pinLikeRepository() {
            return new MBPLikeRepository<>();
        }
    }
}
