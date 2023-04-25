package com.bytedance.juejin.login.password;

import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.domain.user.UserRepository;
import com.bytedance.juejin.login.LoginVO;
import com.bytedance.juejin.token.TokenCodec;
import com.github.linyuzai.domain.core.condition.LambdaConditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordLoginController {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected TokenCodec tokenCodec;

    @PostMapping("/login")
    public LoginVO login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.get(new LambdaConditions().equal(User::getUsername, username));
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("login.username-or-password.error");
        }
        if (!user.getEnabled()) {
            throw new IllegalStateException("login.account.disabled");
        }
        String token = tokenCodec.encode(user);
        LoginVO vo = new LoginVO();
        vo.setId(user.getId());
        vo.setNickname(user.getNickname());
        vo.setAvatar(user.getAvatar());
        vo.setToken(token);
        return vo;
    }

    //eyJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2ODIyMTQ4OTEsImlkIjoiYWRtaW4ifQ.OuHgScoymOvaKZf3sINUc8Xeq3XVB-OQ8vCr94bAjfQ
}
