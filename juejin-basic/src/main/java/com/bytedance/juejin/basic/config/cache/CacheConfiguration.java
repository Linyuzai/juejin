package com.bytedance.juejin.basic.config.cache;

import com.bytedance.juejin.basic.cache.CacheAdapter;
import com.bytedance.juejin.basic.cache.CacheProvider;
import com.bytedance.juejin.basic.cache.CacheProviderImpl;
import com.bytedance.juejin.basic.cache.memory.InMemoryCacheAdapter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * 缓存配置
 */
@Configuration
public class CacheConfiguration {

    @Bean
    @Order
    public InMemoryCacheAdapter inMemoryCacheAdapter() {
        return new InMemoryCacheAdapter();
    }

    @Bean
    @ConditionalOnMissingBean
    public CacheProvider cacheProvider(List<CacheAdapter> cacheAdapters) {
        return new CacheProviderImpl(cacheAdapters);
    }
}
