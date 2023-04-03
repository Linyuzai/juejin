package com.bytedance.juejin.basic.rpc.api.user;

import com.bytedance.juejin.domain.user.User;
import com.github.linyuzai.domain.core.Identifiable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserRO implements Identifiable {

    private String id;

    private String nickname;

    private String avatar;

    public UserRO(User user) {
        this.id = user.getId();
        this.nickname = user.getNickname();
        this.avatar = user.getAvatar();
    }
}
