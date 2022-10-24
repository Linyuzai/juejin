package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerComments;
import com.bytedance.juejin.pin.domain.comment.view.CommentCreateCommand;
import com.bytedance.juejin.pin.domain.like.LikeRepository;
import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerLikes;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CommentFacadeAdapterImpl implements CommentFacadeAdapter {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Comment from(CommentCreateCommand create, User user) {
        String id = generateId();
        return new CommentImpl.Builder()
                .id(id)
                .content(create.getContent())
                .user(user)
                .comments(new SchrodingerComments.Builder()
                        .pinId(create.getPinId())
                        .commentId(id)
                        .commentRepository(commentRepository)
                        .build())
                .likes(new SchrodingerLikes.Builder()
                        .pinId(create.getPinId())
                        .commentId(id)
                        .likeRepository(likeRepository)
                        .build())
                .build();
    }

    public String generateId() {
        //雪花算法等方式生成ID
        return UUID.randomUUID().toString();
    }
}
