package com.bytedance.juejin.basic.mbp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ComponentScan(basePackages = "com.bytedance.juejin.*.config.mbp")
@Import(MBPConfiguration.class)
public @interface EnableMyBatisPlusRepository {
}
