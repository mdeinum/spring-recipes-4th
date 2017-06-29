package com.apress.springrecipes.websocket;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class EchoHandler {

    @RequestMapping("/echo")
    public Mono<OutputText> echo(@RequestBody Mono<InputText> input) {
        return input.map(m -> new OutputText(m.getMsg()));
    }

    @RequestMapping("/reverse")
    public Mono<OutputText> reverse(@RequestBody Mono<InputText> input) {
        return input.map(InputText::getMsg).map(t -> new StringBuilder(t).reverse().toString()).map(OutputText::new);
    }

    @RequestMapping("/echo-chars")
    public Flux<OutputText> echoChars(@RequestBody Mono<InputText> input) {

        Flux.from(input)

        return input.flatMap(s -> Flux.fromArray(() -> s.getMsg().split(""))).map(OutputText::new);
    }
}
