package com.bytedance.juejin.basic.rpc.feign.user;

import com.bytedance.juejin.basic.rpc.api.Response;
import com.bytedance.juejin.basic.rpc.api.user.UserRO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "juejin-user")
public interface UserFeignClient {

    @GetMapping("/user/{id}")
    Response<UserRO> get(@PathVariable String id);
}
