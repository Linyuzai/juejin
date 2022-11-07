package com.bytedance.juejin.pin.domain.user;

import com.bytedance.juejin.pin.domain.user.schrodinger.SchrodingerUser;
import com.bytedance.juejin.pin.domain.user.view.UserVO;
import org.springframework.stereotype.Component;

@Component
public class UserInstantiatorImpl implements UserInstantiator {

    @Override
    public UserImpl.Builder newBuilder() {
        return new UserImpl.Builder();
    }

    @Override
    public SchrodingerUser.Builder newSchrodingerBuilder() {
        return new SchrodingerUser.Builder();
    }

    @Override
    public UserVO newView() {
        return new UserVO();
    }
}
