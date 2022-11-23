package com.bytedance.juejin.basic.rpc.feign.user;

import com.bytedance.juejin.basic.rpc.api.Response;
import com.bytedance.juejin.basic.rpc.api.user.UserRO;
import com.bytedance.juejin.basic.rpc.api.user.UserApi;
import org.springframework.beans.factory.annotation.Autowired;

public class FeignUserApi implements UserApi {

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    public UserRO get(String id) {
        Response<UserRO> response = userFeignClient.get(id);
        if (response.isSuccess()) {
            return response.getObject();
        }
        throw new RuntimeException(response.getMessage());
    }
}
