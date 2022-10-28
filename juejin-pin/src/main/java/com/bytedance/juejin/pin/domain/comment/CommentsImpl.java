package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * 评论
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentsImpl extends AbstractDomainCollection<Comment> implements Comments {

    protected CommentsImpl(Object owner, Map<String, Comment> comments) {
        super(owner, comments);
    }

    public static class Builder extends AbstractDomainCollection.Builder<Comment, CommentsImpl, Builder> {

        @Override
        protected CommentsImpl doBuild() {
            return new CommentsImpl(owner, getObjectMap());
        }
    }
}
