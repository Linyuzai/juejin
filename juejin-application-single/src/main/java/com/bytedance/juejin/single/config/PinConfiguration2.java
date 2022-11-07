package com.bytedance.juejin.single.config;

import com.bytedance.juejin.basic.config.mbp.ConditionalOnMyBatisPlus;
import com.bytedance.juejin.pin.domain.pin.*;
import com.bytedance.juejin.pin.domain.pin.mbp.MBPPinRepository2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PinConfiguration2 {

    @Bean
    public PinController pinController() {
        return new PinController2();
    }

    @Bean
    public PinFacadeAdapter pinFacadeAdapter() {
        return new PinFacadeAdapterImpl2();
    }

    @Bean
    public PinInstantiator pinInstantiator() {
        return new PinInstantiatorImpl2();
    }

    @Configuration
    @ConditionalOnMyBatisPlus
    public static class MyBatisPlusConfiguration {

        @Bean
        public PinRepository pinRepository() {
            return new MBPPinRepository2();
        }
    }
}
