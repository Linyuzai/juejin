package com.bytedance.juejin.security.login;

import com.bytedance.juejin.domain.user.User;
import com.github.linyuzai.cloud.web.servlet.WebContextManager;

public class LoginContext {

    private static final String USER = LoginContext.class.getName() + "@user";

    public static User getUser() {
        return WebContextManager.get().get(USER);
    }

    public static void setUser(User user) {
        WebContextManager.get().put(USER, user);
    }
}
