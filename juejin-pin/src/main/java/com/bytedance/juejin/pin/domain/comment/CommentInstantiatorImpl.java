package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerComment;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerCommentComments;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerPinComments;
import com.bytedance.juejin.pin.domain.comment.view.CommentVO;
import org.springframework.stereotype.Component;

/**
 * 评论实例化器实现
 */
@Component
public class CommentInstantiatorImpl implements CommentInstantiator {

    @Override
    public CommentImpl.Builder newBuilder() {
        return new CommentImpl.Builder();
    }

    @Override
    public SchrodingerComment.Builder newSchrodingerBuilder() {
        return new SchrodingerComment.Builder();
    }

    @Override
    public SchrodingerPinComments.Builder newSchrodingerCollectionBuilderOwnedPin() {
        return new SchrodingerPinComments.Builder();
    }

    @Override
    public SchrodingerCommentComments.Builder newSchrodingerCollectionBuilderOwnedComment() {
        return new SchrodingerCommentComments.Builder();
    }

    @Override
    public CommentVO newView() {
        return new CommentVO();
    }
}
