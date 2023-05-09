package com.bytedance.juejin.gateway.router;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.route.RouteDefinition;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class RoutersRefreshedEvent {

    private final List<RouteDefinition> routeDefinitions;
}
