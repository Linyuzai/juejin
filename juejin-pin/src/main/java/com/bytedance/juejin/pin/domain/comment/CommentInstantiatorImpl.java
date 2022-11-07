package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerComment;
import com.bytedance.juejin.pin.domain.comment.view.CommentVO;
import org.springframework.stereotype.Component;

@Component
public class CommentInstantiatorImpl implements CommentInstantiator{

    @Override
    public CommentImpl.Builder newBuilder() {
        return new CommentImpl.Builder();
    }

    @Override
    public SchrodingerComment.Builder newSchrodingerBuilder() {
        return new SchrodingerComment.Builder();
    }

    @Override
    public CommentVO newView() {
        return new CommentVO();
    }
}
