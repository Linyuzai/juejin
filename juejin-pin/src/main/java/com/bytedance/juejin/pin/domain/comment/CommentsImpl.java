package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import com.bytedance.juejin.basic.exception.JuejinCanNotHappenException;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 评论
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentsImpl extends AbstractDomainCollection<Comment> implements Comments {

    protected CommentsImpl(Object owner) {
        this.owner = owner;
    }

    @Override
    public Object doGetOwner() {
        throw new JuejinCanNotHappenException();
    }

    @Override
    public Comment doGet(String id) {
        throw new JuejinNotFoundException(Comment.class, id);
    }

    public static class Builder extends AbstractDomainCollection.Builder<CommentsImpl, Builder> {

        @Override
        protected CommentsImpl doBuild() {
            return new CommentsImpl(owner);
        }
    }
}
