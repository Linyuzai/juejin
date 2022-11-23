package com.bytedance.juejin.basic.autoconfigure.feign;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "juejin.rpc.feign")
public class FeignProperties {

    private boolean enabled = true;
}
