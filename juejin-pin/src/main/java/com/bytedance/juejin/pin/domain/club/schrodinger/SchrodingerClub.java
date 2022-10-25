package com.bytedance.juejin.pin.domain.club.schrodinger;

import com.bytedance.juejin.basic.domain.ContextDomainBuilder;
import com.bytedance.juejin.basic.domain.DomainContext;
import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubImpl;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
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
        //如果名称为 null 则先从存储读取
        if (super.getName() == null) {
            load();
        }
        return super.getName();
    }

    /**
     * 获得圈子标签
     */
    @Override
    public String getTag() {
        //如果标签为 null 则先从存储读取
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
        //如果描述为 null 则先从存储读取
        if (super.getDescription() == null) {
            load();
        }
        return super.getDescription();
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
        this.tag = club.getTag();
        this.description = club.getDescription();
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
