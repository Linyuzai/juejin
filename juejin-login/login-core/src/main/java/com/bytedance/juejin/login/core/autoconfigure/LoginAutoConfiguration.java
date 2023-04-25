package com.bytedance.juejin.login.core.autoconfigure;

import com.bytedance.juejin.login.core.Login;
import com.bytedance.juejin.login.core.LoginArgumentAdapter;
import com.bytedance.juejin.login.core.LoginHandlerMethodArgumentResolver;
import com.bytedance.juejin.login.core.LoginUserArgumentAdapter;
import com.github.linyuzai.cloud.web.core.intercept.annotation.BreakIntercept;
import com.github.linyuzai.cloud.web.core.intercept.annotation.OnRequest;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.lang.NonNull;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class LoginAutoConfiguration {

    @Order(-1)
    @BreakIntercept
    @OnRequest
    public boolean nonIntercept(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/login/");
    }

    @Bean
    public LoginUserArgumentAdapter loginUserArgumentAdapter() {
        return new LoginUserArgumentAdapter();
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
}
