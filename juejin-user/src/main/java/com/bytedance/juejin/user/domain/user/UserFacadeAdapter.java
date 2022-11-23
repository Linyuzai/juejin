package com.bytedance.juejin.user.domain.user;

import com.bytedance.juejin.basic.rpc.api.user.UserRO;
import com.bytedance.juejin.user.domain.user.view.UserVO;

public interface UserFacadeAdapter {

    UserVO do2vo(User user);

    UserRO do2ro(User user);
}
