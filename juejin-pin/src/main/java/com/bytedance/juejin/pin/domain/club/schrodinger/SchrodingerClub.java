package com.bytedance.juejin.pin.domain.club.schrodinger;

import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.club.ClubRepository;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public class SchrodingerClub extends Club {

    protected ClubRepository clubRepository;

    protected SchrodingerClub(String id, ClubRepository clubRepository) {
        this.id = id;
        this.clubRepository = clubRepository;
    }

    @Override
    public String getName() {
        if (super.getName() == null) {
            load();
        }
        return super.getName();
    }

    @Override
    public String getTag() {
        if (super.getTag() == null) {
            load();
        }
        return super.getTag();
    }

    @Override
    public String getDescription() {
        if (super.getDescription() == null) {
            load();
        }
        return super.getDescription();
    }

    /**
     * 根据 id 加载其他的数据
     */
    public void load() {
        Club club = getClubRepository().get(id);
        if (club == null) {
            throw new JuejinException("Club not found: " + id);
        }
        this.name = club.getName();
        this.tag = club.getTag();
        this.description = club.getDescription();
    }

    public static class Builder {

        protected String id;

        protected ClubRepository clubRepository;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder clubRepository(ClubRepository clubRepository) {
            this.clubRepository = clubRepository;
            return this;
        }

        public SchrodingerClub build() {
            if (!StringUtils.hasText(id)) {
                throw new IllegalArgumentException("Id required");
            }
            if (clubRepository == null) {
                throw new IllegalArgumentException("ClubRepository required");
            }
            return new SchrodingerClub(id, clubRepository);
        }
    }
}
