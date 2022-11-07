package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand2;
import com.bytedance.juejin.pin.domain.user.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;

public class PinController2 extends PinController {

    @Operation(summary = "发布沸点")
    @PostMapping("/v2")
    public void create(PinCreateCommand2 create, User user) {
        super.create(create, user);
    }
}
