package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainValidator;
import com.bytedance.juejin.pin.domain.club.view.ClubCreateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubQuery;
import com.bytedance.juejin.pin.domain.club.view.ClubUpdateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;
import com.bytedance.juejin.pin.domain.pin.PinInstantiator;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserInstantiator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 圈子模型与视图的转换适配器实现
 */
@Component
public class ClubFacadeAdapterImpl implements ClubFacadeAdapter {

    /**
     * 圈子 id 生成器
     */
    @Autowired
    private ClubIdGenerator clubIdGenerator;

    /**
     * 领域上下文
     */
    @Autowired
    private DomainContext context;

    /**
     * 领域校验器
     */
    @Autowired
    private DomainValidator validator;

    /**
     * 圈子实例化器
     */
    @Autowired
    private ClubInstantiator clubInstantiator;

    /**
     * 沸点实例化器
     */
    @Autowired
    private PinInstantiator pinInstantiator;

    /**
     * 用户实例化器
     */
    @Autowired
    private UserInstantiator userInstantiator;

    /**
     * 创建视图转圈子模型
     */
    @Override
    public Club from(ClubCreateCommand create, User user) {
        String id = clubIdGenerator.generateId(Club.class);
        return clubInstantiator.newBuilder()
                .id(id)
                .name(create.getName())
                .logo(create.getLogo())
                .category(create.getCategory())
                .description(create.getDescription())
                .users(userInstantiator.newSchrodingerCollectionBuilderOwnedClub()
                        .clubId(id)
                        .context(context)
                        .validator(validator)
                        .build())
                .pins(pinInstantiator.newSchrodingerCollectionBuilderOwnedClub()
                        .clubId(id)
                        .context(context)
                        .validator(validator)
                        .build())
                .validator(validator)
                .build();
    }

    /**
     * 更新视图转圈子模型
     */
    @Override
    public Club from(ClubUpdateCommand update, Club old, User user) {
        return clubInstantiator.newBuilder()
                .id(update.getId())
                .name(update.getName())
                .logo(update.getLogo())
                .category(update.getCategory())
                .description(update.getDescription())
                .announcement(old.getAnnouncement())
                .users(old.getUsers())
                .pins(old.getPins())
                .validator(validator)
                .build();
    }

    /**
     * 圈子模型转圈子视图
     */
    @Override
    public ClubVO do2vo(Club club) {
        ClubVO vo = clubInstantiator.newView();
        vo.setId(club.getId());
        vo.setName(club.getName());
        vo.setLogo(club.getLogo());
        vo.setCategory(club.getCategory());
        vo.setDescription(club.getDescription());
        vo.setAnnouncement(club.getAnnouncement());
        vo.setUserCount(club.getUsers().count());
        vo.setPinCount(club.getPins().count());
        return vo;
    }

    /**
     * 圈子查询转条件
     */
    @Override
    public Conditions toConditions(ClubQuery query) {
        LambdaConditions conditions = new LambdaConditions();
        conditions.like(Club::getName, query.getName(), false);
        return conditions;
    }
}
