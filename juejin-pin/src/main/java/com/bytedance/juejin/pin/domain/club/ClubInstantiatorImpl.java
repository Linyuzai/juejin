package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerClub;
import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerUserClubs;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;
import org.springframework.stereotype.Component;

/**
 * 圈子实例化器实现
 */
@Component
public class ClubInstantiatorImpl implements ClubInstantiator {

    /**
     * 圈子领域模型 Builder
     */
    @Override
    public ClubImpl.Builder newBuilder() {
        return new ClubImpl.Builder();
    }

    /**
     * 圈子薛定谔模型 Builder
     */
    @Override
    public SchrodingerClub.Builder newSchrodingerBuilder() {
        return new SchrodingerClub.Builder();
    }

    /**
     * 用户关注的圈子薛定谔模型 Builder
     */
    @Override
    public SchrodingerUserClubs.Builder newSchrodingerCollectionBuilderOwnedUser() {
        return new SchrodingerUserClubs.Builder();
    }

    /**
     * 圈子视图
     */
    @Override
    public ClubVO newView() {
        return new ClubVO();
    }
}
