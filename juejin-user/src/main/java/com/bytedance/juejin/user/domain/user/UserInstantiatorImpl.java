package com.bytedance.juejin.user.domain.user;

import com.bytedance.juejin.basic.rpc.api.user.UserRO;
import com.bytedance.juejin.user.domain.user.view.UserVO;
import org.springframework.stereotype.Component;

@Component
public class UserInstantiatorImpl implements UserInstantiator {

    @Override
    public UserImpl.Builder newBuilder() {
        return new UserImpl.Builder();
    }

    @Override
    public UserVO newView() {
        return new UserVO();
    }

    @Override
    public UserRO newRemote() {
        return new UserRO();
    }
}
