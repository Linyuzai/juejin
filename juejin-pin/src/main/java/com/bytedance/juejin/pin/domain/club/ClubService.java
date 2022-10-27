package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.domain.DomainEventPublisher;
import com.bytedance.juejin.pin.domain.club.event.ClubCreatedEvent;
import com.bytedance.juejin.pin.domain.club.event.ClubUpdatedEvent;
import com.bytedance.juejin.pin.domain.club.view.ClubCreateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubUpdateCommand;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {

    @Autowired
    private ClubFacadeAdapter clubFacadeAdapter;

    @Autowired
    private ClubRepository clubRepository;

    @Autowired
    private DomainEventPublisher eventPublisher;

    public void create(ClubCreateCommand create, User user) {
        Club club = clubFacadeAdapter.from(create, user);
        clubRepository.create(club);
        eventPublisher.publish(new ClubCreatedEvent(club, user));
    }

    public void update(ClubUpdateCommand update, User user) {
        Club oldClub = clubRepository.get(update.getId());
        Club newClub = clubFacadeAdapter.from(update, oldClub, user);
        clubRepository.update(newClub);
        eventPublisher.publish(new ClubUpdatedEvent(oldClub, newClub, user));
    }
}
