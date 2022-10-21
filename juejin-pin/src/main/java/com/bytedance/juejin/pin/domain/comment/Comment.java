package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainEntity;
import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment implements DomainEntity {

    protected String id;

    protected String content;

    protected User user;

    protected Map<String, Comment> comments;

    protected Collection<Like> likes;

    protected Long createTime;

    public void commented(Comment comment) {
        if (comments == null) {
            throw new IllegalArgumentException("Comment is null");
        }
        if (comments.containsKey(comment.getId())) {
            throw new IllegalArgumentException("Comment existed");
        }
        comments.put(comment.getId(), comment);
    }

    public Comment getComment(String commentId) {
        return comments.get(commentId);
    }

    public static class Builder {

        protected String id;

        protected String content;

        protected User user;

        public Comment build() {
            if (id == null) {
                throw new IllegalArgumentException("Id existed");
            }
            if (content == null) {
                throw new IllegalArgumentException("Content existed");
            }
            if (user == null) {
                throw new IllegalArgumentException("User existed");
            }
            return new Comment(
                    id,
                    content,
                    user,
                    new LinkedHashMap<>(),
                    new ArrayList<>(),
                    System.currentTimeMillis());
        }
    }
}
