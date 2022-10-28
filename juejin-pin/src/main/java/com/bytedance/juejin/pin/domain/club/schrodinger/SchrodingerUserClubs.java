package com.bytedance.juejin.pin.domain.club.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.domain.DomainRepository;
import com.bytedance.juejin.pin.domain.club.Clubs;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 薛定谔的用户圈子集合模型
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerUserClubs extends SchrodingerClubs implements Clubs {

    protected SchrodingerUserClubs(String userId, DomainContext context) {
        this.ownerId = userId;
        this.context = context;
    }

    /**
     * 基于用户 id 做条件查询
     */
    @Override
    protected void onConditionsObtain(Conditions conditions, String id) {
        conditions.lambda().equal(User::getId, id);
    }

    /**
     * 圈子的所有者为用户
     */
    @Override
    protected Class<?> getOwnerType() {
        return User.class;
    }

    /**
     * 圈子的所有者存储为用户存储
     */
    @Override
    protected Class<? extends DomainRepository<?>> getOwnerRepositoryType() {
        return UserRepository.class;
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerUserClubs, Builder> {

        @NotNull
        protected String userId;

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        @Override
        protected SchrodingerUserClubs doBuild() {
            return new SchrodingerUserClubs(userId, context);
        }
    }
}
