package com.bytedance.juejin.basic;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;

/**
 * 单体应用需要而微服务不需要注入的组件
 */
@Configuration
@AllArgsConstructor
public class JuejinBootConfiguration {

}
