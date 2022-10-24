package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerClub;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.pin.view.PinSnapshotVO;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 沸点领域模型和视图的转换适配器
 */
@Component
public class PinFacadeAdapterImpl implements PinFacadeAdapter {

    /**
     * 圈子存储
     */
    @Autowired
    private ClubRepository clubRepository;

    @Override
    public Pin from(PinCreateCommand create, User user) {
        return new PinImpl.Builder()
                .id(generateId())
                .content(create.getContent())
                .club(getClub(create.getClubId()))
                .user(user)
                .build();
    }

    @Override
    public PinVO do2vo(Pin pin) {
        return null;
    }

    @Override
    public PinSnapshotVO toSnapshot(Pin pin) {
        return null;
    }

    /**
     * 获得圈子领域模型
     */
    public Club getClub(String clubId) {
        if (clubId == null) {
            return null;
        }
        //返回薛定谔的圈子模型
        return new SchrodingerClub.Builder()
                .id(clubId)
                .clubRepository(clubRepository)
                .build();
    }

    public String generateId() {
        //雪花算法等方式生成ID
        return UUID.randomUUID().toString();
    }
}
