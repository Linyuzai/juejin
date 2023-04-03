package com.bytedance.juejin.basic.login;

import com.github.linyuzai.cloud.web.servlet.WebContextManager;

public class LoginContext {

    private static final String USER_ID = LoginContext.class.getName() + "@userId";

    public static String getUserId() {
        return WebContextManager.get().get(USER_ID);
    }

    public static void setUserId(String userId) {
        WebContextManager.get().put(USER_ID, userId);
    }
}
