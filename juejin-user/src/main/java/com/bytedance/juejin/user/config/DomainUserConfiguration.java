package com.bytedance.juejin.user.config;

import com.bytedance.juejin.basic.autoconfigure.mbp.ConditionalOnMyBatisPlus;
import com.bytedance.juejin.basic.rpc.api.user.UserApi;
import com.bytedance.juejin.user.domain.user.*;
import com.bytedance.juejin.user.domain.user.mbp.MBPUserRepository;
import com.bytedance.juejin.user.domain.user.rpc.InnerUserApi;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainUserConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public UserController userController() {
        return new UserController();
    }

    @Bean
    @ConditionalOnMissingBean
    public UserFacadeAdapter userFacadeAdapter() {
        return new UserFacadeAdapterImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public UserInstantiator userInstantiator() {
        return new UserInstantiatorImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    public UserSearcher userSearcher() {
        return new UserSearcherImpl();
    }

    @Bean
    public UserApi userApi() {
        return new InnerUserApi();
    }

    /**
     * 用户 MyBatis-Plus 配置
     */
    @Configuration
    @ConditionalOnMyBatisPlus
    public static class MyBatisPlusConfiguration {

        @Bean
        @ConditionalOnMissingBean
        public UserRepository userRepository() {
            return new MBPUserRepository<>();
        }
    }
}
