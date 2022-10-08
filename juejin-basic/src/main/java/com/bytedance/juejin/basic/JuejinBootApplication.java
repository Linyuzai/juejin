package com.bytedance.juejin.basic;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(JuejinBootConfiguration.class)
@ComponentScan(
        basePackages = "com.bytedance.juejin",
        excludeFilters = @ComponentScan.Filter(
                type = FilterType.REGEX,
                pattern = "com.bytedance.juejin.basic.*"
        )
)
@SpringBootApplication
public @interface JuejinBootApplication {
}
