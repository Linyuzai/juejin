package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.domain.comment.Comment;
import com.bytedance.juejin.domain.comment.CommentRepository;
import com.bytedance.juejin.domain.comment.CommentService;
import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.pin.domain.comment.view.CommentCreateCommand;
import com.bytedance.juejin.pin.domain.comment.view.CommentDeleteCommand;
import com.github.linyuzai.domain.core.exception.DomainNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 评论领域服务
 */
@Service
public class CommentApplicationService {

    @Autowired
    private CommentService commentService;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentFacadeAdapter commentFacadeAdapter;

    public void create(CommentCreateCommand create, User user) {
        Comment comment = commentFacadeAdapter.from(create, user);
        commentService.create(comment, user);
    }

    public void delete(CommentDeleteCommand delete, User user) {
        Comment comment = commentRepository.get(delete.getId());
        if (comment == null) {
            throw new DomainNotFoundException(Comment.class, delete.getId());
        }
        commentService.delete(comment, user);
    }
}
