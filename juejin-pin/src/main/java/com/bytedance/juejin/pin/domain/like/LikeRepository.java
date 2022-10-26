package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.DomainRepository;

public interface LikeRepository extends DomainRepository<Like> {

    Like get(String pinId, String userId);

    Like get(String pinId, String commentId, String userId);

    long count(String pinId);

    long count(String pinId, String commentId);
}
