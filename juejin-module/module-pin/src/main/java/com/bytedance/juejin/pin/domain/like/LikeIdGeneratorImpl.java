package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.pin.domain.like.view.LikeCreateCommand;
import org.springframework.stereotype.Component;

/**
 * 点赞 id 生成器
 */
@Component
public class LikeIdGeneratorImpl implements LikeIdGenerator {

    @Override
    public String generateId(Object[] object) {
        LikeCreateCommand command = (LikeCreateCommand) object[0];
        User user = (User) object[1];
        return command.getType().toLowerCase() + "_" + command.getLikedId() + "_" + user.getId();
    }
}
