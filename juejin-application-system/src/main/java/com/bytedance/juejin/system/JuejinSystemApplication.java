package com.bytedance.juejin.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bytedance.juejin")
public class JuejinSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuejinSystemApplication.class, args);
    }
}
