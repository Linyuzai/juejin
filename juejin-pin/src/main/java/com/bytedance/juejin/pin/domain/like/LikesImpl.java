package com.bytedance.juejin.pin.domain.like;

import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LikesImpl implements Likes {

    protected Map<String, Like> likes = new HashMap<>();

    @Override
    public boolean add(Like like) {
        if (like == null) {
            throw new IllegalArgumentException("Like required");
        }
        return getLikes().put(like.getUser().getId(), like) == null;
    }

    @Override
    public boolean delete(Like like) {
        if (like == null) {
            throw new IllegalArgumentException("Like required");
        }
        return getLikes().remove(like.getUser().getId()) != null;
    }

    @Override
    public Like get(String userId) {
        if (!StringUtils.hasText(userId)) {
            throw new IllegalArgumentException("User id required");
        }
        return getLikes().get(userId);
    }

    @Override
    public long count() {
        return getLikes().size();
    }
}
