package com.bytedance.juejin.user.infrastructure.user.feign;

import com.bytedance.juejin.basic.rpc.user.RPCUserFacadeAdapter;
import com.bytedance.juejin.basic.rpc.user.UserRO;
import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign/user")
public class FeignUserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RPCUserFacadeAdapter rpcUserFacadeAdapter;

    @GetMapping("/{id}")
    public UserRO get(@PathVariable String id) {
        User user = userRepository.get(id);
        if (user == null) {
            return null;
        }
        return rpcUserFacadeAdapter.do2ro(user);
    }
}
