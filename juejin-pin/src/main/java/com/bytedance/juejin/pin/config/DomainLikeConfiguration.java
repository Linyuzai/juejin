package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.basic.config.mbp.ConditionalOnMyBatisPlus;
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
    public LikeFacadeAdapter likeFacadeAdapter() {
        return new LikeFacadeAdapterImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public LikeInstantiator likeInstantiator() {
        return new LikeInstantiatorImpl();
    }

    @Configuration
    @ConditionalOnMyBatisPlus
    public static class MyBatisPlusConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public LikeIdGenerator likeIdGenerator() {
            return new MBPLikeIdGenerator();
        }

        @Bean
        @ConditionalOnMissingBean
        public LikeRepository likeRepository() {
            return new MBPLikeRepository<>();
        }
    }
}
