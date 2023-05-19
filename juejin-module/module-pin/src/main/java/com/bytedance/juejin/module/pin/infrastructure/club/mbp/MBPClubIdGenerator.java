package com.bytedance.juejin.module.pin.infrastructure.club.mbp;

import com.bytedance.juejin.module.pin.domain.club.view.ClubCreateCommand;
import com.bytedance.juejin.module.pin.domain.club.ClubIdGenerator;
import com.github.linyuzai.domain.mbp.MBPDomainIdGenerator;
import org.springframework.stereotype.Component;

/**
 * 基于 MBP id 生成器 的 圈子 id 生成器
 */
@Component
public class MBPClubIdGenerator extends MBPDomainIdGenerator<ClubCreateCommand> implements ClubIdGenerator {
}
