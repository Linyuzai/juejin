package com.bytedance.juejin.pin.domain.like.mbp;

import com.bytedance.juejin.basic.domain.mbp.MBPDomainIdGenerator;
import com.bytedance.juejin.pin.domain.like.Like;
import com.bytedance.juejin.pin.domain.like.LikeIdGenerator;
import org.springframework.stereotype.Component;

/**
 * 点赞 id 生成器
 */
@Component
public class MBPLikeIdGenerator extends MBPDomainIdGenerator<Like> implements LikeIdGenerator {
}
