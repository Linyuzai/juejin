package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.domain.DomainEventPublisher;
import com.bytedance.juejin.basic.exception.JuejinException;
import com.bytedance.juejin.pin.domain.comment.CommentRepository;
import com.bytedance.juejin.pin.domain.like.LikeRepository;
import com.bytedance.juejin.pin.domain.pin.event.PinCreatedEvent;
import com.bytedance.juejin.pin.domain.pin.event.PinDeletedEvent;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.pin.view.PinDeleteCommand;
import com.bytedance.juejin.pin.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PinService {

    @Autowired
    private PinFacadeAdapter pinFacadeAdapter;

    @Autowired
    private PinRepository pinRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private DomainEventPublisher eventPublisher;

    public void create(PinCreateCommand create, User user) {
        Pin pin = pinFacadeAdapter.from(create, user);
        pinRepository.create(pin);
        eventPublisher.publish(new PinCreatedEvent(pin, user));
    }

    @Transactional
    public void delete(PinDeleteCommand delete, User user) {
        Pin pin = pinRepository.get(delete.getId());
        if (pin == null) {
            throw new JuejinException("沸点不存在");
        }
        pinRepository.delete(pin);
        commentRepository.delete(pin.getComments().values());
        likeRepository.delete(pin.getLikes());
        eventPublisher.publish(new PinDeletedEvent(pin, user));
    }
}
