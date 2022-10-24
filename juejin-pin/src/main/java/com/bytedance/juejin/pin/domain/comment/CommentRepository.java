package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainRepository;

public interface CommentRepository extends DomainRepository<Comment> {

    void delete(Comments comments);

    long count(String pinId);

    long count(String pinId, String commentId);
}
