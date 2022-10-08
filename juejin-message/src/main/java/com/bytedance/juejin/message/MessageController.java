package com.bytedance.juejin.message;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @GetMapping("message")
    public String test() {
        return "message";
    }
}
