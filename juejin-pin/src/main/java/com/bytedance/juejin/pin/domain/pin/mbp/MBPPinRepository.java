package com.bytedance.juejin.pin.domain.pin.mbp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bytedance.juejin.basic.domain.mbp.MBPDomainRepository;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerClub;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.comment.CommentSearcher;
import com.bytedance.juejin.pin.domain.comment.schrodinger.SchrodingerComments;
import com.bytedance.juejin.pin.domain.pin.Pin;
import com.bytedance.juejin.pin.domain.pin.PinImpl;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import com.bytedance.juejin.pin.domain.user.schrodinger.SchrodingerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MBPPinRepository extends MBPDomainRepository<Pin, PinPO> {

    @Autowired
    private PinMapper pinMapper;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentSearcher commentSearcher;

    @Override
    public PinPO do2po(Pin pin) {
        PinPO po = new PinPO();
        po.setId(pin.getId());
        po.setContent(pin.getContent());
        po.setClubId(pin.getClub().getId());
        po.setUserId(pin.getUser().getId());
        po.setCreateTime(new Date(pin.getCreateTime()));
        return po;
    }

    @Override
    public Pin po2do(PinPO po) {
        return new PinImpl.Builder()
                .id(po.getId())
                .content(po.getContent())
                .club(new SchrodingerClub.Builder()
                        .id(po.getClubId())
                        .clubRepository(clubRepository)
                        .build())
                .user(new SchrodingerUser.Builder()
                        .id(po.getUserId())
                        .userRepository(userRepository)
                        .build())
                .comments(new SchrodingerComments.Builder()
                        .pinId(po.getId())
                        .commentRepository(commentRepository)
                        .commentSearcher(commentSearcher)
                        .build())
                .likes(null)
                .createTime(po.getCreateTime().getTime())
                .build();
    }

    @Override
    public BaseMapper<PinPO> getBaseMapper() {
        return pinMapper;
    }
}
