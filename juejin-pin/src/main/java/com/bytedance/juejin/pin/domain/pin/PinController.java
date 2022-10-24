package com.bytedance.juejin.pin.domain.pin;

import com.bytedance.juejin.basic.page.Pages;
import com.bytedance.juejin.basic.user.Login;
import com.bytedance.juejin.pin.domain.pin.view.PinCreateCommand;
import com.bytedance.juejin.pin.domain.pin.view.PinDeleteCommand;
import com.bytedance.juejin.pin.domain.pin.view.PinSnapshotVO;
import com.bytedance.juejin.pin.domain.pin.view.PinVO;
import com.bytedance.juejin.pin.domain.user.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "沸点")
@RestController
@RequestMapping("/pin")
public class PinController {

    @Autowired
    private PinService pinService;

    @Autowired
    private PinSearcher pinSearcher;

    @Operation(summary = "发布沸点")
    @PostMapping
    public void create(@RequestBody PinCreateCommand create, @Login User user) {
        pinService.create(create, user);
    }

    @Operation(summary = "删除沸点")
    @DeleteMapping
    public void delete(@RequestBody PinDeleteCommand delete, @Login User user) {
        pinService.delete(delete, user);
    }

    @Operation(summary = "沸点详情")
    @GetMapping("/{id}")
    public PinVO get(@PathVariable String id) {
        return pinSearcher.get(id);
    }

    @Operation(summary = "分页查询沸点快照")
    @GetMapping("/page")
    public Pages<PinSnapshotVO> page(Pages.Args page) {
        return pinSearcher.page(page);
    }
}