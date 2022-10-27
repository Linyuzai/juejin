package com.bytedance.juejin.pin.config;

import com.bytedance.juejin.pin.domain.user.UserRepository;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@EnableOpenApi
@Configuration
public class PinConfiguration {

    /*@Bean
    public Docket pinApi() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("沸点")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bytedance.juejin.pin"))
                .paths(PathSelectors.any())
                .build();
    }*/

    @Bean
    public GroupedOpenApi pinApi() {
        return GroupedOpenApi.builder()
                .group("沸点")
                .packagesToScan("com.bytedance.juejin.pin")
                .build();
    }

    @Bean
    public UserLoginArgumentAdapter userLoginArgumentAdapter(UserRepository userRepository) {
        return new UserLoginArgumentAdapter(userRepository);
    }
}
