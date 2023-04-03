package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.view.*;
import com.github.linyuzai.domain.core.condition.Conditions;

/**
 * 圈子模型与视图的转换适配器
 */
public interface ClubFacadeAdapter {

    /**
     * 创建视图转圈子模型
     */
    Club from(ClubCreateCommand create);

    /**
     * 更新视图转圈子模型
     */
    Club from(ClubUpdateCommand update, Club old);

    /**
     * 圈子模型转圈子视图
     */
    ClubVO do2vo(Club club);

    ClubFullVO do2full(Club club);

    /**
     * 圈子查询转条件
     */
    Conditions toConditions(ClubQuery query);
}
