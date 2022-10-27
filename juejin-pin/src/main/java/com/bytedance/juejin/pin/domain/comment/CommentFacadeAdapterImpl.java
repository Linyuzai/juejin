package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerComment;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerCommentComments;
import com.bytedance.juejin.pin.domain.comment.view.CommentCreateCommand;
import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerLikes;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentFacadeAdapterImpl implements CommentFacadeAdapter {

    @Autowired
    private CommentIdGenerator commentIdGenerator;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Override
    public Comment from(CommentCreateCommand create, User user) {
        String id = commentIdGenerator.generateId(Comment.class);
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
        return new CommentImpl.Builder()
                .id(id)
                .owner(owner)
                .content(create.getContent())
                .user(user)
                .comments(new SchrodingerCommentComments.Builder()
                        .commentId(id)
                        .context(context)
                        .validator(validator)
                        .build())
                .likes(new SchrodingerLikes.Builder()
                        .pinId(create.getPinId())
                        .commentId(id)
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
    }
}
