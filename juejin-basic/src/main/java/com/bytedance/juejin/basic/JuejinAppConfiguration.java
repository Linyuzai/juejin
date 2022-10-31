package com.bytedance.juejin.basic;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainEventPublisher;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.spring.ApplicationDomainContext;
import com.bytedance.juejin.basic.domain.spring.ApplicationDomainEventPublisher;
import com.bytedance.juejin.basic.domain.spring.ApplicationDomainValidator;
import com.bytedance.juejin.basic.login.Login;
import com.bytedance.juejin.basic.login.LoginArgumentAdapter;
import com.bytedance.juejin.basic.login.LoginHandlerMethodArgumentResolver;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 单体应用和微服务都需要注入的组件
 */
@Configuration
@AllArgsConstructor
public class JuejinAppConfiguration implements WebMvcConfigurer {

    private List<LoginArgumentAdapter> argumentAdapters;

    /**
     * 对于 Controller 上标记 {@link Login} 的参数进行匹配设置
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginHandlerMethodArgumentResolver(argumentAdapters));
    }

    /**
     * 领域事件发布器
     */
    @Bean
    public DomainEventPublisher domainEventPublisher(ApplicationEventPublisher publisher) {
        return new ApplicationDomainEventPublisher(publisher);
    }

    /**
     * 领域上下文
     */
    @Bean
    public DomainContext domainContext(ApplicationContext context) {
        return new ApplicationDomainContext(context);
    }

    /**
     * 领域校验器
     */
    @Bean
    public DomainValidator domainValidator(Validator validator) {
        return new ApplicationDomainValidator(validator);
    }

    /*@Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }*/

}
