package com.bytedance.juejin.pin.domain.user;

import com.bytedance.juejin.pin.domain.user.schrodinger.SchrodingerUser;
import com.bytedance.juejin.pin.domain.user.view.UserVO;

public interface UserInstantiator {

    UserImpl.Builder newBuilder();

    SchrodingerUser.Builder newSchrodingerBuilder();

    UserVO newView();
}
