package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.login.Login;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand2;
import com.bytedance.juejin.pin.domain.user.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 沸点 Controller v2
 */
public class PinController2 extends PinController {

    @Operation(summary = "发布沸点v2")
    @PostMapping("/v2")
    public void create(@RequestBody PinCreateCommand2 create, @Login User user) {
        super.create(create, user);
    }
}
