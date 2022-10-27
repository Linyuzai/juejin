package com.bytedance.juejin.pin.domain.club.mbp;

import com.bytedance.juejin.basic.domain.mbp.MBPDomainIdGenerator;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubIdGenerator;
import org.springframework.stereotype.Component;

@Component
public class MBPClubIdGenerator extends MBPDomainIdGenerator<Club> implements ClubIdGenerator {
}
