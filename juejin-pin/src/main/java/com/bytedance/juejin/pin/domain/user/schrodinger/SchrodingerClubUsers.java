package com.bytedance.juejin.pin.domain.user.schrodinger;

import com.bytedance.juejin.basic.condition.Conditions;
import com.bytedance.juejin.basic.condition.LambdaConditions;
import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinIdRequiredException;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.UserRepository;
import com.bytedance.juejin.pin.domain.user.Users;
import com.bytedance.juejin.pin.domain.user.UsersImpl;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SchrodingerClubUsers extends UsersImpl implements Users {

    protected String clubId;

    protected DomainContext context;

    @Override
    public Object doGetOwner() {
        ClubRepository clubRepository = getContext().get(ClubRepository.class);
        String id = getClubId();
        Club club = clubRepository.get(id);
        if (club == null) {
            throw new JuejinNotFoundException(Club.class, id);
        }
        return club;
    }

    @Override
    public User doGet(String id) {
        if (!StringUtils.hasText(id)) {
            throw new JuejinIdRequiredException(User.class);
        }
        UserRepository userRepository = getContext().get(UserRepository.class);
        User user = userRepository.get(id);
        if (user == null) {
            return super.doGet(id);
        }
        return user;
    }

    @Override
    public Stream<User> stream() {
        UserRepository userRepository = getContext().get(UserRepository.class);
        return userRepository.stream(obtainConditions());
    }

    @Override
    public long count() {
        UserRepository userRepository = getContext().get(UserRepository.class);
        return userRepository.count(obtainConditions());
    }

    protected Conditions obtainConditions() {
        LambdaConditions conditions = new LambdaConditions();
        conditions.equal(Club::getId, getClubId());
        return conditions;
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerClubUsers, Builder> {

        @NotEmpty
        protected String clubId;

        public Builder clubId(String clubId) {
            this.clubId = clubId;
            return this;
        }

        @Override
        protected SchrodingerClubUsers doBuild() {
            return new SchrodingerClubUsers(clubId, context);
        }
    }
}
