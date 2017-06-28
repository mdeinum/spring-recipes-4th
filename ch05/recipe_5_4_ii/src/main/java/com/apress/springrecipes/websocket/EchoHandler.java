package com.apress.springrecipes.websocket;

import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.stereotype.Controller;

@Controller
public class EchoHandler {

//    @MessageMapping("/echo")
    @SubscribeMapping("/echo")
    public String echo(String msg) {
        return "RECEIVED: " + msg;
    }
}
