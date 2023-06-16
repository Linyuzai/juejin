package com.bytedance.juejin.login;

import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.token.TokenCodec;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginAuthorizerImpl implements LoginAuthorizer {

    private TokenCodec tokenCodec;

    @Override
    public LoginAuthorization authorize(User user) {
        String token = tokenCodec.encode(user);
        LoginAuthorization la = new LoginAuthorization();
        la.setId(user.getId());
        la.setNickname(user.getNickname());
        la.setAvatar(user.getAvatar());
        la.setToken(token);
        return la;
    }
}
