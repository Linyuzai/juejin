package com.bytedance.juejin.user.domain.user.rpc;

import com.bytedance.juejin.basic.rpc.api.user.UserRO;
import com.bytedance.juejin.basic.rpc.api.user.UserApi;
import com.bytedance.juejin.user.domain.user.User;
import com.bytedance.juejin.user.domain.user.UserFacadeAdapter;
import com.bytedance.juejin.user.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InnerUserApi implements UserApi {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFacadeAdapter userFacadeAdapter;

    @Override
    public UserRO get(String id) {
        User user = userRepository.get(id);
        return userFacadeAdapter.do2ro(user);
    }
}
