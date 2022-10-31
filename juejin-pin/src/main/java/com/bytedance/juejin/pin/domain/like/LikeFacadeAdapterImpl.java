package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerComment;
import com.bytedance.juejin.pin.domain.like.view.LikeCreateCommand;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LikeFacadeAdapterImpl implements LikeFacadeAdapter {

    @Autowired
    private LikeIdGenerator likeIdGenerator;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Override
    public Like from(LikeCreateCommand create, User user) {
        String id = likeIdGenerator.generateId(Like.class);
        PinOrComment owner;
        if (create.getCommentId() == null) {
            owner = new SchrodingerPin.Builder()
                    .id(create.getPinId())
                    .context(context)
                    .validator(validator)
                    .build();
        } else {
            owner = new SchrodingerComment.Builder()
                    .id(create.getCommentId())
                    .context(context)
                    .validator(validator)
                    .build();
        }
        return new LikeImpl.Builder()
                .id(id)
                .owner(owner)
                .user(user)
                .validator(validator)
                .build();
    }
}