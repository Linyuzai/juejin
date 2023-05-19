package com.bytedance.juejin.module.pin.domain.comment;

import com.bytedance.juejin.module.pin.domain.comment.view.CommentCreateCommand;
import com.github.linyuzai.domain.core.DomainIdGenerator;

/**
 * 评论 id 生成器
 */
public interface CommentIdGenerator extends DomainIdGenerator<CommentCreateCommand> {
}
