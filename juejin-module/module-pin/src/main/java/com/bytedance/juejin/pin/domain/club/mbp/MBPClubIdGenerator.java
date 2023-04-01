package com.bytedance.juejin.pin.domain.club.mbp;

import com.bytedance.juejin.basic.domain.mbp.MBPDomainIdGenerator;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubIdGenerator;
import org.springframework.stereotype.Component;

/**
 * 基于 {@link com.baomidou.mybatisplus.core.toolkit.IdWorker} 的圈子 id 生成器
 */
@Component
public class MBPClubIdGenerator extends MBPDomainIdGenerator<Club> implements ClubIdGenerator {
}
