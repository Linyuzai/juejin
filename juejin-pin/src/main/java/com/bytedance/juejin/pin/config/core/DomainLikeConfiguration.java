package com.bytedance.juejin.pin.config.core;

import com.bytedance.juejin.pin.domain.like.LikeController;
import com.bytedance.juejin.pin.domain.like.LikeFacadeAdapter;
import com.bytedance.juejin.pin.domain.like.LikeFacadeAdapterImpl;
import com.bytedance.juejin.pin.domain.like.LikeService;
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
}
