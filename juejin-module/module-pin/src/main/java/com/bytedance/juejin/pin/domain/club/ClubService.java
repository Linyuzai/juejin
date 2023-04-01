package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.domain.DomainEventPublisher;
import com.bytedance.juejin.basic.exception.JuejinNotFoundException;
import com.bytedance.juejin.pin.domain.club.event.ClubAnnouncementPublishedEvent;
import com.bytedance.juejin.pin.domain.club.event.ClubCreatedEvent;
import com.bytedance.juejin.pin.domain.club.event.ClubUpdatedEvent;
import com.bytedance.juejin.pin.domain.club.view.ClubAnnouncementPublishCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubCreateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubUpdateCommand;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 圈子服务
 */
@Service
public class ClubService {

    /**
     * 圈子模型与视图的转换适配器
     */
    @Autowired
    private ClubFacadeAdapter clubFacadeAdapter;

    /**
     * 圈子存储
     */
    @Autowired
    private ClubRepository clubRepository;

    /**
     * 领域事件发布器
     */
    @Autowired
    private DomainEventPublisher eventPublisher;

    /**
     * 创建圈子
     */
    public void create(ClubCreateCommand create, User user) {
        Club club = clubFacadeAdapter.from(create, user);
        clubRepository.create(club);
        eventPublisher.publish(new ClubCreatedEvent(club, user));
    }

    /**
     * 更新圈子
     */
    public void update(ClubUpdateCommand update, User user) {
        Club club = clubRepository.get(update.getId());
        if (club == null) {
            throw new JuejinNotFoundException(Club.class, update.getId());
        }
        Club newClub = clubFacadeAdapter.from(update, club, user);
        clubRepository.update(newClub);
        eventPublisher.publish(new ClubUpdatedEvent(club, newClub, user));
    }

    /**
     * 发布公告
     */
    public void publishAnnouncement(ClubAnnouncementPublishCommand publish, User user) {
        Club club = clubRepository.get(publish.getId());
        Club newClub = club.publishAnnouncement(publish.getAnnouncement());
        clubRepository.update(newClub);
        eventPublisher.publish(new ClubAnnouncementPublishedEvent(club, publish.getAnnouncement(), user));
    }
}
