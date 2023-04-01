package com.bytedance.juejin.basic;

import com.bytedance.juejin.basic.cloud.RouterRegister;
import com.bytedance.juejin.basic.rpc.RouterLoadBalancerClientFactory;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClientsProperties;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 微服务需要而单体应用不需要注入的组件
 */
@Configuration
public class JuejinCloudConfiguration {

    @Bean
    public RouterRegister routerRegister() {
        return new RouterRegister();
    }

    @Bean
    public LoadBalancerClientFactory routerLoadBalancerClientFactory(LoadBalancerClientsProperties properties,
                                                                     DiscoveryClient discoveryClient) {
        return new RouterLoadBalancerClientFactory(properties, discoveryClient);
    }
}
