package com.bytedance.juejin.pin.domain.club;

import com.bytedance.juejin.basic.login.Login;
import com.bytedance.juejin.pin.domain.club.view.ClubCreateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubQuery;
import com.bytedance.juejin.pin.domain.club.view.ClubUpdateCommand;
import com.bytedance.juejin.pin.domain.club.view.ClubVO;
import com.bytedance.juejin.pin.domain.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "圈子")
@RestController
@RequestMapping("club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @Autowired
    private ClubSearcher clubSearcher;

    @Operation(summary = "新建圈子")
    @PostMapping
    public void create(@RequestBody ClubCreateCommand create, @Login User user) {
        clubService.create(create, user);
    }

    @Operation(summary = "更新圈子")
    @PutMapping
    public void update(@RequestBody ClubUpdateCommand update, @Login User user) {
        clubService.update(update, user);
    }

    @Operation(summary = "圈子详情")
    @GetMapping("/{id}")
    public ClubVO get(@PathVariable String id) {
        return clubSearcher.get(id);
    }

    @Operation(summary = "圈子列表")
    @GetMapping("/list")
    public List<ClubVO> list(ClubQuery query) {
        return clubSearcher.list(query);
    }
}
