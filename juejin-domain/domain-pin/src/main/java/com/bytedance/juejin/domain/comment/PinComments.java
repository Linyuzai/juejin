package com.bytedance.juejin.domain.comment;

import com.github.linyuzai.domain.core.condition.Conditions;
import com.github.linyuzai.domain.core.proxy.DomainProxy;

import java.util.List;
import java.util.stream.Collectors;

public interface PinComments extends Comments<PinComment>,
        DomainProxy.RepositoryAccess<PinComment>,
        DomainProxy.ConditionsAccess,
        DomainProxy.ExtraAccess<List<PinComment>> {

    /**
     * 获得最新的 n 条评论
     */
    default List<PinComment> getNewestList(int count) {
        List<PinComment> extra = getExtra();
        if (extra == null) {
            Conditions conditions = Conditions.from(getConditions()).lambda()
                    .orderBy(PinComment::getCreateTime, true)
                    .limit(count);
            //CommentRepository repository = getContext().get(CommentRepository.class);
            List<PinComment> comments = getRepository().select(conditions)
                    .stream()
                    //.map(PinComment.class::cast)
                    .collect(Collectors.toList());
            setExtra(comments);
            return comments;
        } else {
            return extra;
        }
    }
}
