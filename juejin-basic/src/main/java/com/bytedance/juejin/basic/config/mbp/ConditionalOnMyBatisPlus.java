package com.bytedance.juejin.basic.config.mbp;

import com.baomidou.mybatisplus.core.MybatisPlusVersion;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnProperty(name = "juejin.repository.mybatis-plus.enabled", havingValue = "true")
public @interface ConditionalOnMyBatisPlus {
}
