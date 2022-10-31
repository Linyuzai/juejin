package com.bytedance.juejin.pin.domain.comment;

import com.bytedance.juejin.basic.domain.DomainCollection;

import java.util.List;

public interface Comments extends DomainCollection<Comment> {

    List<Comment> getNewestList(int count);
}
