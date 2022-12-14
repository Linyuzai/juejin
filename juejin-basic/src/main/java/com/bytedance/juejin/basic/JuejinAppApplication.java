package com.bytedance.juejin.basic;

import com.bytedance.juejin.basic.name.JuejinBeanNameGenerator;
import com.github.linyuzai.concept.cloud.web.EnableWebConcept;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 单体应用和微服务通用组件的基础注解
 * <p>
 * 指定配置扫描路径，每个模块的 Controller Service Repository 等组件默认不自动注入
 * <p>
 * 通过对应的配置类和 {@link ConditionalOnMissingBean} 方便在 application 模块中重写扩展
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(JuejinAppConfiguration.class)
@EnableWebConcept
@ComponentScan(basePackages = "com.bytedance.juejin.*.config",
        nameGenerator = JuejinBeanNameGenerator.class)
@SpringBootApplication
public @interface JuejinAppApplication {
}
