package com.bytedance.juejin.basic.mbp;

import com.baomidou.mybatisplus.core.MybatisPlusVersion;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@ConditionalOnClass(MybatisPlusVersion.class)
public @interface ConditionalOnMyBatisPlus {
}
