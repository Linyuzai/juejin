package com.bytedance.juejin.user.domain.user;

import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.user.domain.user.view.UserVO;

public interface UserFacadeAdapter {

    UserVO do2vo(User user);
}
