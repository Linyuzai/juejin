package com.bytedance.juejin.pin;

import com.bytedance.juejin.basic.page.PageQuery;
import com.bytedance.juejin.basic.page.PageVO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pin")
public class PinController {

    @PostMapping
    public void create(@RequestBody PinCreateCommand create) {

    }

    @PutMapping
    public void update(@RequestBody PinUpdateCommand update) {

    }

    @DeleteMapping
    public void delete(@RequestBody PinDeleteCommand delete) {

    }

    @GetMapping("/page")
    public PageVO<PinVO> page(PageQuery page) {
        return new PageVO<>();
    }
}