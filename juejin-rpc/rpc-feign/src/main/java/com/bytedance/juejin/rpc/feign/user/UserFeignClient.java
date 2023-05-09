package com.bytedance.juejin.rpc.feign.user;

import com.bytedance.juejin.rpc.Response;
import com.bytedance.juejin.rpc.user.UserRO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 用户 Feign 客户端
 */
@FeignClient(name = "user")
public interface UserFeignClient {

    /**
     * 根据 id 获得用户信息
     */
    @GetMapping("/feign/user/{id}")
    Response<UserRO> get(@PathVariable String id);
}
