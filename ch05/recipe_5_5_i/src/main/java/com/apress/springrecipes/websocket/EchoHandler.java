package com.apress.springrecipes.websocket;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EchoHandler {

    @RequestMapping("/echo")
    public Mono<String> echo(@RequestParam("msg") String msg) {
        return Mono.just(msg);
    }

    @RequestMapping("/reverse")
    public Mono<String> reverse(@RequestParam("msg") String msg) {
        return Mono.just(msg).map(s -> new StringBuilder(s).reverse().toString());
    }

    @RequestMapping("/echo-chars")
    public Flux<String> echoChars(@RequestParam("msg") String msg) {

        return Flux.fromStream(msg.chars().mapToObj(i -> (char) i).map(String::valueOf));
    }
}
