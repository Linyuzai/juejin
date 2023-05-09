package com.bytedance.juejin.gateway.swagger;

import com.bytedance.juejin.gateway.router.RoutersRefreshedEvent;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.AbstractSwaggerUiConfigProperties;
import org.springdoc.core.SwaggerUiConfigProperties;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CloudSpringDocAggregation {

    private final SwaggerUiConfigProperties swaggerUiConfigProperties;

    @EventListener
    public void updateSpringDoc(RoutersRefreshedEvent event) {
        Set<AbstractSwaggerUiConfigProperties.SwaggerUrl> urls =
                event.getRouteDefinitions()
                        .stream()
                        .map(this::toUrl)
                        .collect(Collectors.toSet());
        swaggerUiConfigProperties.setUrls(urls);
    }

    private AbstractSwaggerUiConfigProperties.SwaggerUrl toUrl(RouteDefinition route) {
        AbstractSwaggerUiConfigProperties.SwaggerUrl url =
                new AbstractSwaggerUiConfigProperties.SwaggerUrl();
        String router = (String) route.getMetadata().get("router");
        url.setName(router);
        url.setUrl(router + "/v3/api-docs/");
        return url;
    }
}
