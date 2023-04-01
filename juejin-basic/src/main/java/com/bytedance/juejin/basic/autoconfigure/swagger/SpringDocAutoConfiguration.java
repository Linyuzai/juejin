package com.bytedance.juejin.basic.autoconfigure.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;

@Configuration
public class SpringDocAutoConfiguration {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Juejin API")
                        .version("1.0"))
                .addSecurityItem(new SecurityRequirement()
                        .addList(HttpHeaders.AUTHORIZATION))
                .components(new Components()
                        .addSecuritySchemes(HttpHeaders.AUTHORIZATION, new SecurityScheme()
                                .name(HttpHeaders.AUTHORIZATION)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")));
    }
}
