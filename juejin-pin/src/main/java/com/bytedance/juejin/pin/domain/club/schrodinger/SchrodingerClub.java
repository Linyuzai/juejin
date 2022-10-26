package com.bytedance.juejin.pin.domain.club.schrodinger;

import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubImpl;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import com.bytedance.juejin.pin.domain.pin.Pins;
import com.bytedance.juejin.pin.domain.user.User;
import com.bytedance.juejin.pin.domain.user.Users;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;

/**
 * 薛定谔的圈子模型
 */
@Getter
public class SchrodingerClub extends ClubImpl implements Club {

    /**
     * 圈子存储
     */
    protected DomainContext context;

    protected SchrodingerClub(String id, DomainContext context) {
        this.id = id;
        this.context = context;
    }

    /**
     * 获得圈子名称
     */
    @Override
    public String getName() {
        if (super.getName() == null) {
            load();
        }
        return super.getName();
    }

    /**
     * 获得圈子图标
     */
    @Override
    public String getLogo() {
        if (super.getLogo() == null) {
            load();
        }
        return super.getLogo();
    }

    /**
     * 获得圈子标签
     */
    @Override
    public String getTag() {
        if (super.getTag() == null) {
            load();
        }
        return super.getTag();
    }

    /**
     * 获得圈子描述
     */
    @Override
    public String getDescription() {
        if (super.getDescription() == null) {
            load();
        }
        return super.getDescription();
    }

    /**
     * 获得圈子公告
     */
    @Override
    public String getAnnouncement() {
        if (super.getAnnouncement() == null) {
            load();
        }
        return super.getAnnouncement();
    }

    /**
     * 获得圈子管理员
     */
    @Override
    public User getAdmin() {
        if (super.getAdmin() == null) {
            load();
        }
        return super.getAdmin();
    }

    /**
     * 获得关注圈子的用户
     */
    @Override
    public Users getUsers() {
        if (super.getUsers() == null) {
            load();
        }
        return super.getUsers();
    }

    /**
     * 获得圈子下的沸点
     */
    @Override
    public Pins getPins() {
        if (super.getPins() == null) {
            load();
        }
        return super.getPins();
    }

    /**
     * 根据 id 加载其他的数据
     */
    public void load() {
        ClubRepository clubRepository = getContext().get(ClubRepository.class);
        Club club = clubRepository.get(id);
        if (club == null) {
            throw new JuejinException("Club not found: " + id);
        }
        this.name = club.getName();
        this.logo = club.getLogo();
        this.tag = club.getTag();
        this.description = club.getDescription();
        this.announcement = club.getAnnouncement();
        this.admin = club.getAdmin();
        this.users = club.getUsers();
        this.pins = club.getPins();
    }

    public static class Builder extends ContextDomainBuilder<SchrodingerClub, Builder> {

        @NotEmpty
        protected String id;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        @Override
        public SchrodingerClub doBuild() {
            return new SchrodingerClub(id, context);
        }
    }
}
