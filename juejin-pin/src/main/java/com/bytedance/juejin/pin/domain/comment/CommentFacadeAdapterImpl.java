package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.pin.domain.PinOrComment;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerComment;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerCommentComments;
import com.bytedance.juejin.pin.domain.comment.view.CommentCreateCommand;
import com.bytedance.juejin.pin.domain.comment.view.CommentQuery;
import com.bytedance.juejin.pin.domain.comment.view.CommentReplyVO;
import com.bytedance.juejin.pin.domain.comment.view.CommentVO;
import com.bytedance.juejin.pin.domain.like.schrodinger.SchrodingerCommentLikes;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.schrodinger.SchrodingerPin;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserFacadeAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class CommentFacadeAdapterImpl implements CommentFacadeAdapter {

    @Autowired
    private CommentIdGenerator commentIdGenerator;

    @Autowired
    private DomainContext context;

    @Autowired
    private DomainValidator validator;

    @Autowired
    private UserFacadeAdapter userFacadeAdapter;

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
                .likes(new SchrodingerCommentLikes.Builder()
                        .commentId(id)
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
    }

    @Override
    public CommentVO do2vo(Comment comment) {
        CommentVO vo = new CommentVO();
        vo.setId(comment.getId());
        vo.setContent(comment.getContent());
        vo.setUser(userFacadeAdapter.do2vo(comment.getUser()));
        vo.setReplies(getCommentReplyList(comment));
        vo.setCommentCount((long) vo.getReplies().size());
        vo.setLikeCount(comment.getLikes().count());
        vo.setCreateTime(comment.getCreateTime());
        return vo;
    }

    public List<CommentReplyVO> getCommentReplyList(Comment comment) {
        List<CommentReplyVO> list = new ArrayList<>();
        collectCommentReplyList(comment, list);
        list.sort(Comparator.comparingInt(o -> o.getCreateTime().intValue()));
        return list;
    }

    public void collectCommentReplyList(Comment comment, List<CommentReplyVO> list) {
        comment.getComments().stream().forEach(it -> {
            CommentReplyVO vo = new CommentReplyVO();
            vo.setId(it.getId());
            vo.setContent(it.getContent());
            vo.setUser(userFacadeAdapter.do2vo(it.getUser()));
            vo.setReply(userFacadeAdapter.do2vo(comment.getUser()));
            vo.setLikeCount(it.getLikes().count());
            vo.setCreateTime(it.getCreateTime());
            list.add(vo);
            collectCommentReplyList(it, list);
        });
    }

    @Override
    public Conditions toConditions(CommentQuery query) {
        LambdaConditions conditions = new LambdaConditions();
        conditions.equal(Pin::getId, query.getPinId());
        conditions.isNull(Comment::getId);
        conditions.orderBy(Comment::getCreateTime, true, false);
        return conditions;
    }
}
