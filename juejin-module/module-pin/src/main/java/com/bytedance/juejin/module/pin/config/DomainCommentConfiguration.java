package com.bytedance.juejin.module.pin.config;

import com.bytedance.juejin.domain.comment.CommentRepository;
import com.bytedance.juejin.domain.comment.CommentService;
import com.bytedance.juejin.module.pin.domain.comment.*;
import com.bytedance.juejin.module.pin.infrastructure.comment.mbp.MBPCommentRepository;
import com.github.linyuzai.domain.mbp.MBPDomainIdGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 评论配置
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
    public CommentApplicationService commentApplicationService() {
        return new CommentApplicationService();
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

    /**
     * MyBatis-Plus 配置
     */
    @Configuration
    public static class MyBatisPlusConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public CommentIdGenerator commentIdGenerator() {
            return MBPDomainIdGenerator.create(CommentIdGenerator.class);
        }

        @Bean
        @ConditionalOnMissingBean
        public CommentRepository pinCommentRepository() {
            return new MBPCommentRepository();
        }
    }
}
