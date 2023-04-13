package com.bytedance.juejin.login;

import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.domain.user.UserRepository;
import com.bytedance.juejin.security.token.TokenCodec;
import com.github.linyuzai.domain.core.condition.LambdaConditions;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    protected UserRepository userRepository;

    @Autowired
    protected TokenCodec tokenCodec;

    @PostMapping("/login")
    public LoginVO login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.get(new LambdaConditions().equal(User::getUsername, username));
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("账号或密码错误");
        }
        if (!user.getEnabled()) {
            throw new IllegalStateException("账号已禁用");
        }
        String token = tokenCodec.encode(user);
        LoginVO vo = new LoginVO();
        vo.setId(user.getId());
        vo.setNickname(user.getNickname());
        vo.setToken(token);
        return vo;
    }

    @Data
    public static class LoginVO {

        private String id;

        private String nickname;

        private String token;
    }
}
