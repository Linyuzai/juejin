package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.domain.DomainObject;

public interface Likes extends DomainObject {

    boolean add(Like like);

    boolean delete(Like like);

    Like get(String userId);

    long count();
}
