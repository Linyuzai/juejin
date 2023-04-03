package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.domain.pin.Pin;
import com.bytedance.juejin.domain.pin.PinRepository;
import com.bytedance.juejin.domain.pin.PinService;
import com.bytedance.juejin.domain.user.User;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.pin.view.PinDeleteCommand;
import com.github.linyuzai.domain.core.exception.DomainNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 沸点服务
 */
@Service
public class PinApplicationService {

    @Autowired
    private PinService pinService;

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
     * 添加（发布）一条沸点
     */
    public void create(PinCreateCommand create, User user) {
        //获得领域模型
        Pin pin = pinFacadeAdapter.from(create, user);
        //添加（发布）沸点
        pinService.create(pin, user);
    }

    /**
     * 删除一条沸点
     */
    public void delete(PinDeleteCommand delete, User user) {
        //获得对应的沸点
        Pin pin = pinRepository.get(delete.getId());
        if (pin == null) {
            throw new DomainNotFoundException(Pin.class, delete.getId());
        }
        //删除沸点
        pinService.delete(pin, user);
    }
}
