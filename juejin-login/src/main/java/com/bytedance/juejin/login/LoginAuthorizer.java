package com.bytedance.juejin.login;

import com.bytedance.juejin.domain.user.User;

public interface LoginAuthorizer {

    LoginAuthorization authorize(User user);
}
