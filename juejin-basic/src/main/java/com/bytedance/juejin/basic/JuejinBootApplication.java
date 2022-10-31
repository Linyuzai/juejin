package com.bytedance.juejin.basic;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 单体应用启动注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(JuejinBootConfiguration.class)
@JuejinAppApplication
public @interface JuejinBootApplication {
}
