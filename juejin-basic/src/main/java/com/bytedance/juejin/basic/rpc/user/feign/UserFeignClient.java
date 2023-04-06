package com.bytedance.juejin.basic.rpc.user.feign;

import com.bytedance.juejin.basic.rpc.Response;
import com.bytedance.juejin.basic.rpc.user.UserRO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "juejin-user")
public interface UserFeignClient {

    @GetMapping("/feign/user/{id}")
    Response<UserRO> get(@PathVariable String id);
}
