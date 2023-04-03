package com.bytedance.juejin.pin.infrastructure.club.mbp;

import com.bytedance.juejin.pin.domain.club.ClubIdGenerator;
import com.bytedance.juejin.pin.domain.club.view.ClubCreateCommand;
import com.github.linyuzai.domain.mbp.MBPDomainIdGenerator;
import org.springframework.stereotype.Component;

/**
 * 基于 {@link com.baomidou.mybatisplus.core.toolkit.IdWorker} 的圈子 id 生成器
 */
@Component
public class MBPClubIdGenerator extends MBPDomainIdGenerator<ClubCreateCommand> implements ClubIdGenerator {
}
