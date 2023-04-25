package com.bytedance.juejin.token.core;

import com.bytedance.juejin.domain.user.User;

public interface TokenCodec {

    String encode(User user);

    User decode(String token);
}
