package com.bytedance.juejin.user.domain.user;

import com.bytedance.juejin.user.domain.user.view.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSearcherImpl implements UserSearcher {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserFacadeAdapter userFacadeAdapter;

    @Override
    public UserVO get(String id) {
        return userFacadeAdapter.do2vo(userRepository.get(id));
    }
}
