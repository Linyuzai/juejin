package com.bytedance.juejin.pin.domain.like;

import com.bytedance.juejin.basic.login.Login;
import com.bytedance.juejin.pin.domain.like.view.LikeCreateCommand;
import com.bytedance.juejin.pin.domain.like.view.LikeDeleteCommand;
import com.bytedance.juejin.pin.domain.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "沸点点赞")
@RestController
@RequestMapping("pin-like")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @Operation(summary = "点赞")
    @PostMapping
    public void create(@RequestBody LikeCreateCommand create, @Login User user) {
        likeService.create(create, user);
    }

    @Operation(summary = "取消点赞")
    @DeleteMapping
    public void delete(@RequestBody LikeDeleteCommand delete, @Login User user) {
        likeService.delete(delete, user);
    }
}
