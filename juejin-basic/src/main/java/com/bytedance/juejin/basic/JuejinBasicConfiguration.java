package com.bytedance.juejin.basic;

import com.bytedance.juejin.basic.login.Login;
import com.bytedance.juejin.basic.login.LoginArgumentAdapter;
import com.bytedance.juejin.basic.login.LoginHandlerMethodArgumentResolver;
import com.bytedance.juejin.basic.login.UserLoginArgumentAdapter;
import com.bytedance.juejin.domain.user.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 单体应用和微服务都需要注入的组件
 */
@Configuration
@AllArgsConstructor
public class JuejinBasicConfiguration {

    @Bean
    public LoginArgumentAdapter userLoginArgumentAdapterInBase() {
        return new UserLoginArgumentAdapter(User.class);
    }

    @Configuration
    @AllArgsConstructor
    public static class MvcConfiguration implements WebMvcConfigurer {

        private List<LoginArgumentAdapter> argumentAdapters;

        /**
         * 对于 Controller 上标记 {@link Login} 的参数进行匹配设置
         */
        @Override
        public void addArgumentResolvers(@NonNull List<HandlerMethodArgumentResolver> resolvers) {
            resolvers.add(new LoginHandlerMethodArgumentResolver(argumentAdapters));
        }
    }

    /*@Bean(initMethod = "init", destroyMethod = "close")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DruidDataSource druidDataSource() {
        return new DruidDataSource();
    }*/

}
