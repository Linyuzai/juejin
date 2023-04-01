package com.bytedance.juejin.pin.domain.user;

import com.bytedance.juejin.pin.domain.user.view.UserVO;

public interface UserFacadeAdapter {

    UserVO do2vo(User user);
}
