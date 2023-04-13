package com.bytedance.juejin.security.token.autoconfigure;

import com.bytedance.juejin.security.token.TokenCodec;
import com.bytedance.juejin.security.token.TokenWebInterceptor;
import com.bytedance.juejin.security.token.jwt.JwtTokenCodec;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TokenAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TokenCodec tokenCodec() {
        return new JwtTokenCodec();
    }

    @Bean
    @ConditionalOnMissingBean
    public TokenWebInterceptor tokenWebInterceptor() {
        return new TokenWebInterceptor();
    }
}
