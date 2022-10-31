package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.pin.domain.user.UserFacadeAdapter;
import com.bytedance.juejin.pin.domain.user.UserFacadeAdapterImpl;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import com.bytedance.juejin.pin.domain.user.mock.MockUserRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 用户领域相关配置
 */
@Configuration
public class DomainUserConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public UserFacadeAdapter userFacadeAdapter() {
        return new UserFacadeAdapterImpl();
    }

    @Configuration
    public static class MockConfiguration {

        /**
         * 暂时写在这里，等到写服务间调用的时候再重新实现
         */
        @Bean
        @ConditionalOnMissingBean
        public UserRepository userRepository() {
            return new MockUserRepository();
        }
    }
}
