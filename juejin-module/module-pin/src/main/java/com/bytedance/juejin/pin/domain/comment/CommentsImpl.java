package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.AbstractDomainCollection;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 评论集合实现
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentsImpl extends AbstractDomainCollection<Comment> implements Comments {

    protected CommentsImpl(Object owner, Map<String, Comment> comments) {
        super(owner, comments);
    }

    @Override
    public List<Comment> getNewestList(int count) {
        return getObjects().values()
                .stream()
                .sorted((o1, o2) -> o2.getCreateTime().intValue() - o1.getCreateTime().intValue())
                .limit(count)
                .collect(Collectors.toList());
    }

    public static class Builder extends AbstractDomainCollection.Builder<Comment, CommentsImpl, Builder> {

        @Override
        protected CommentsImpl doBuild() {
            return new CommentsImpl(owner, getObjectMap());
        }
    }
}
