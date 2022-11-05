package com.bytedance.juejin.basic.config.cache;

import com.bytedance.juejin.basic.cache.CacheProvider;
import com.bytedance.juejin.basic.cache.memory.InMemoryCacheProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public CacheProvider cacheProvider() {
        return new InMemoryCacheProvider();
    }
}
