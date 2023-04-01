package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerClub;
import com.bytedance.juejin.pin.domain.club.schrodinger.SchrodingerUserClubs;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;

/**
 * 圈子实例化器
 */
public interface ClubInstantiator {

    /**
     * 圈子领域模型 Builder
     */
    ClubImpl.Builder newBuilder();

    /**
     * 圈子薛定谔模型 Builder
     */
    SchrodingerClub.Builder newSchrodingerBuilder();

    /**
     * 用户关注的圈子薛定谔模型 Builder
     */
    SchrodingerUserClubs.Builder newSchrodingerCollectionBuilderOwnedUser();

    /**
     * 圈子视图
     */
    ClubVO newView();
}
