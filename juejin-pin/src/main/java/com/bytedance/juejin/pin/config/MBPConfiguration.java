package com.bytedance.juejin.pin.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.bytedance.juejin.pin.domain.*.mbp")
public class MBPConfiguration {
}
