package com.bytedance.juejin.user.domain.user;

import com.bytedance.juejin.user.domain.user.view.UserVO;

public interface UserSearcher {

    UserVO get(String id);
}
