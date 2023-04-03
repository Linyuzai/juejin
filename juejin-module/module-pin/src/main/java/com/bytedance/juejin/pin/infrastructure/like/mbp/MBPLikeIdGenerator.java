package com.bytedance.juejin.pin.infrastructure.like.mbp;

import com.bytedance.juejin.pin.domain.like.LikeIdGenerator;
import com.bytedance.juejin.pin.domain.like.view.LikeCreateCommand;
import com.github.linyuzai.domain.mbp.MBPDomainIdGenerator;
import org.springframework.stereotype.Component;

/**
 * 点赞 id 生成器
 */
@Component
public class MBPLikeIdGenerator extends MBPDomainIdGenerator<LikeCreateCommand> implements LikeIdGenerator {
}
