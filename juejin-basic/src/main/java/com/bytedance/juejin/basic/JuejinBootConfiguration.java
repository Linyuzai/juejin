package com.bytedance.juejin.basic;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainEventPublisher;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.basic.domain.spring.ApplicationDomainContext;
import com.bytedance.juejin.basic.domain.spring.ApplicationDomainEventPublisher;
import com.bytedance.juejin.basic.domain.spring.ApplicationDomainValidator;
import com.bytedance.juejin.basic.login.LoginArgumentAdapter;
import com.bytedance.juejin.basic.login.LoginHandlerMethodArgumentResolver;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@AllArgsConstructor
public class JuejinBootConfiguration implements WebMvcConfigurer {

    private List<LoginArgumentAdapter> argumentAdapters;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new LoginHandlerMethodArgumentResolver(argumentAdapters));
    }

    @Bean
    public DomainEventPublisher domainEventPublisher(ApplicationEventPublisher publisher) {
        return new ApplicationDomainEventPublisher(publisher);
    }

    @Bean
    public DomainContext domainContext(ApplicationContext context) {
        return new ApplicationDomainContext(context);
    }

    @Bean
    public DomainValidator domainValidator() {
        return new ApplicationDomainValidator();
    }

    /*@Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }*/

}
