package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.comment.CommentInstantiator;
import com.bytedance.juejin.pin.domain.like.view.LikeCreateCommand;
import com.bytedance.juejin.pin.domain.pin.PinInstantiator;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 点赞模型与视图的转换适配器实现
 */
@Component
public class LikeFacadeAdapterImpl implements LikeFacadeAdapter {

    @Autowired
    private LikeIdGenerator likeIdGenerator;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Autowired
    private PinInstantiator pinInstantiator;

    @Autowired
    private CommentInstantiator commentInstantiator;

    @Autowired
    private LikeInstantiator likeInstantiator;

    @Override
    public Like from(LikeCreateCommand create, User user) {
        String id = likeIdGenerator.generateId(Like.class);
        PinOrComment owner;
        if (create.getCommentId() == null) {
            owner = pinInstantiator.newSchrodingerBuilder()
                    .id(create.getPinId())
                    .context(context)
                    .validator(validator)
                    .build();
        } else {
            owner = commentInstantiator.newSchrodingerBuilder()
                    .id(create.getCommentId())
                    .context(context)
                    .validator(validator)
                    .build();
        }
        return likeInstantiator.newBuilder()
                .id(id)
                .owner(owner)
                .user(user)
                .validator(validator)
                .build();
    }
}
