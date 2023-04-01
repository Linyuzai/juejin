package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.pin.domain.club.view.ClubCreateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubQuery;
import com.bytedance.juejin.pin.domain.club.view.ClubUpdateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;
import com.bytedance.juejin.pin.domain.user.User;

/**
 * 圈子模型与视图的转换适配器
 */
public interface ClubFacadeAdapter {

    /**
     * 创建视图转圈子模型
     */
    Club from(ClubCreateCommand create, User user);

    /**
     * 更新视图转圈子模型
     */
    Club from(ClubUpdateCommand update, Club old, User user);

    /**
     * 圈子模型转圈子视图
     */
    ClubVO do2vo(Club club);

    /**
     * 圈子查询转条件
     */
    Conditions toConditions(ClubQuery query);
}
