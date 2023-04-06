package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.domain.comment.CommentRepository;
import com.bytedance.juejin.domain.comment.CommentService;
import com.bytedance.juejin.pin.domain.comment.*;
import com.bytedance.juejin.pin.infrastructure.comment.mbp.MBPCommentIdGenerator;
import com.bytedance.juejin.pin.infrastructure.comment.mbp.MBPCommentRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 评论领域相关配置
 */
@Configuration
public class DomainCommentConfiguration {

    /**
     * 评论 Controller
     */
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

    /**
     * 评论 Service
     */
    @Bean
    @ConditionalOnMissingBean
    public CommentApplicationService commentApplicationService() {
        return new CommentApplicationService();
    }

    /**
     * 评论模型与视图的转换适配器
     */
    @Bean
    @ConditionalOnMissingBean
    public CommentFacadeAdapter pinCommentFacadeAdapter() {
        return new CommentFacadeAdapterImpl();
    }

    /**
     * 评论搜索器
     */
    @Bean
    @ConditionalOnMissingBean
    public CommentSearcher pinCommentSearcher() {
        return new CommentSearcherImpl();
    }

    /**
     * 评论 MyBatis-Plus 配置
     */
    @Configuration
    public static class MyBatisPlusConfiguration {

        /**
         * 评论 id 生成器
         */
        @Bean
        @ConditionalOnMissingBean
        public CommentIdGenerator pinCommentIdGenerator() {
            return new MBPCommentIdGenerator();
        }

        /**
         * 基于 MyBatis-Plus 的评论存储
         */
        @Bean
        @ConditionalOnMissingBean
        public CommentRepository pinCommentRepository() {
            return new MBPCommentRepository();
        }
    }
}
