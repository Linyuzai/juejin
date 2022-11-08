package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.basic.config.mbp.ConditionalOnMyBatisPlus;
import com.bytedance.juejin.pin.domain.comment.*;
import com.bytedance.juejin.pin.domain.comment.mbp.MBPCommentIdGenerator;
import com.bytedance.juejin.pin.domain.comment.mbp.MBPCommentRepository;
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

    /**
     * 评论 Service
     */
    @Bean
    @ConditionalOnMissingBean
    public CommentService commentService() {
        return new CommentService();
    }

    /**
     * 评论模型与视图的转换适配器
     */
    @Bean
    @ConditionalOnMissingBean
    public CommentFacadeAdapter commentFacadeAdapter() {
        return new CommentFacadeAdapterImpl();
    }

    /**
     * 评论实例化器
     */
    @Bean
    @ConditionalOnMissingBean
    public CommentInstantiator commentInstantiator() {
        return new CommentInstantiatorImpl();
    }

    /**
     * 评论搜索器
     */
    @Bean
    @ConditionalOnMissingBean
    public CommentSearcher commentSearcher() {
        return new CommentSearcherImpl();
    }

    /**
     * 评论 MyBatis-Plus 配置
     */
    @Configuration
    @ConditionalOnMyBatisPlus
    public static class MyBatisPlusConfiguration {

        /**
         * 评论 id 生成器
         */
        @Bean
        @ConditionalOnMissingBean
        public CommentIdGenerator commentIdGenerator() {
            return new MBPCommentIdGenerator();
        }

        /**
         * 基于 MyBatis-Plus 的评论存储
         */
        @Bean
        @ConditionalOnMissingBean
        public CommentRepository commentRepository() {
            return new MBPCommentRepository<>();
        }
    }
}
