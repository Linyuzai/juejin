package com.bytedance.juejin.pin.domain.like;

public interface Likes {

    boolean add(Like like);

    boolean delete(Like like);

    Like get(String userId);

    long count();
}
