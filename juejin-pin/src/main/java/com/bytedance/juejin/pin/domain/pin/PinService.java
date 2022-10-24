package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.domain.DomainEventPublisher;
import com.bytedance.juejin.basic.domain.DomainService;
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

/**
 * 沸点服务
 */
@Service
public class PinService implements DomainService {

    /**
     * 视图和领域模型的转换适配器
     */
    @Autowired
    private PinFacadeAdapter pinFacadeAdapter;

    /**
     * 沸点存储
     */
    @Autowired
    private PinRepository pinRepository;

    /**
     * 评论存储
     */
    @Autowired
    private CommentRepository commentRepository;

    /**
     * 点赞存储
     */
    @Autowired
    private LikeRepository likeRepository;

    /**
     * 领域事件发布器
     */
    @Autowired
    private DomainEventPublisher eventPublisher;

    /**
     * 添加（发布）一条沸点
     */
    public void create(PinCreateCommand create, User user) {
        //获得领域模型
        Pin pin = pinFacadeAdapter.from(create, user);
        //添加（发布）沸点
        pinRepository.create(pin);
        //发布沸点添加（发布）事件
        eventPublisher.publish(new PinCreatedEvent(pin, user));
    }

    /**
     * 删除一条沸点
     */
    @Transactional
    public void delete(PinDeleteCommand delete, User user) {
        //获得对应的沸点
        Pin pin = pinRepository.get(delete.getId());
        if (pin == null) {
            throw new JuejinException("沸点不存在");
        }
        //删除沸点
        pinRepository.delete(pin);
        //删除沸点下面的评论
        commentRepository.delete(pin.getComments());
        //删除沸点下面的点赞
        likeRepository.delete(pin.getLikes());
        //发布沸点删除事件
        afterTransactionCommit(() ->
                eventPublisher.publish(new PinDeletedEvent(pin, user)));
    }
}
