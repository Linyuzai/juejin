package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerComment;
import com.bytedance.juejin.pin.domain.comment.view.CommentVO;

public interface CommentInstantiator {

    CommentImpl.Builder newBuilder();

    SchrodingerComment.Builder newSchrodingerBuilder();

    CommentVO newView();
}
