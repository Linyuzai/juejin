package com.bytedance.juejin;

import com.bytedance.juejin.basic.JuejinBootApplication;
import com.bytedance.juejin.basic.mbp.EnableMyBatisPlusRepository;
import org.springframework.boot.SpringApplication;

@EnableMyBatisPlusRepository
@JuejinBootApplication
public class JuejinSingleApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuejinSingleApplication.class, args);
    }
}
