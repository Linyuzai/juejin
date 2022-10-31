package com.bytedance.juejin.pin.config.core;

import com.bytedance.juejin.pin.domain.comment.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 评论领域相关配置
 */
@Configuration
public class DomainCommentConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public CommentController commentController() {
        return new CommentController();
    }

    @Bean
    @ConditionalOnMissingBean
    public CommentService commentService() {
        return new CommentService();
    }

    @Bean
    @ConditionalOnMissingBean
    public CommentFacadeAdapter commentFacadeAdapter() {
        return new CommentFacadeAdapterImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public CommentSearcher commentSearcher() {
        return new CommentSearcherImpl();
    }
}
