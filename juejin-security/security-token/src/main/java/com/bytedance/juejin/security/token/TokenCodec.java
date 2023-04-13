package com.bytedance.juejin.security.token;

import com.bytedance.juejin.domain.user.User;

public interface TokenCodec {

    String encode(User user);

    User decode(String token);
}
