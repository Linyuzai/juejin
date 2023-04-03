package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.pin.domain.like.view.LikeCreateCommand;
import com.github.linyuzai.domain.core.DomainIdGenerator;

/**
 * 点赞 id 生成器
 */
public interface LikeIdGenerator extends DomainIdGenerator<LikeCreateCommand> {
}
