package com.bytedance.juejin.basic.config.mbp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "juejin.repository.mybatis-plus")
public class MyBatisPlusProperties {

    private boolean enabled = true;
}
