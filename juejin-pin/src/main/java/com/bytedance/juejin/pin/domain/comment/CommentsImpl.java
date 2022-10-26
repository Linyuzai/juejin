package com.bytedance.juejin.pin.domain.comment;


import com.bytedance.juejin.basic.domain.AbstractDomainBuilder;
import com.bytedance.juejin.pin.domain.pin.Pin;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

/**
 * 评论
 */
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentsImpl implements Comments {

    protected Pin pin;

    protected Comment comment;

    protected Map<String, Comment> comments;

    /**
     * 添加评论
     */
    @Override
    public void add(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Comment required");
        }
        getComments().put(comment.getId(), comment);
    }

    /**
     * 删除评论
     */
    @Override
    public void delete(Comment comment) {
        if (comment == null) {
            throw new IllegalArgumentException("Comment required");
        }
        getComments().remove(comment.getId());
    }

    /**
     * 获得评论
     */
    @Override
    public Comment get(String commentId) {
        if (!StringUtils.hasText(commentId)) {
            throw new IllegalArgumentException("Comment id required");
        }
        return getComments().get(commentId);
    }

    /**
     * 评论数量
     */
    @Override
    public long count() {
        return getComments().size();
    }

    public static class Builder extends AbstractDomainBuilder<CommentsImpl, Builder> {

        @NotNull
        protected Pin pin;

        protected Comment comment;

        @NotNull
        protected Map<String, Comment> comments;

        public Builder pin(Pin pin) {
            this.pin = pin;
            return this;
        }

        public Builder comment(Comment comment) {
            this.comment = comment;
            return this;
        }

        public Builder comments(Map<String, Comment> comments) {
            this.comments = comments;
            return this;
        }

        @Override
        protected void initDefaultValue() {
            if (comments == null) {
                comments = new HashMap<>();
            }
        }

        @Override
        public CommentsImpl doBuild() {
            return new CommentsImpl(pin, comment, comments);
        }
    }
}
