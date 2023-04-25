package com.bytedance.juejin.rpc.feign.user;

import com.bytedance.juejin.rpc.core.Response;
import com.bytedance.juejin.rpc.core.user.UserRO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "juejin-user")
public interface UserFeignClient {

    @GetMapping("/feign/user/{id}")
    Response<UserRO> get(@PathVariable String id);
}
