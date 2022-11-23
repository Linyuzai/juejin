package com.bytedance.juejin.user.domain.user;

import com.bytedance.juejin.basic.rpc.api.user.UserRO;
import com.bytedance.juejin.user.domain.user.view.UserVO;

public interface UserInstantiator {

    UserImpl.Builder newBuilder();

    UserVO newView();

    UserRO newRemote();
}
