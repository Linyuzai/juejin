package com.bytedance.juejin.pin.domain.club.event;

import com.bytedance.juejin.pin.domain.club.Club;
import com.bytedance.juejin.pin.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ClubCreatedEvent {

    private final Club club;

    private final User user;
}
