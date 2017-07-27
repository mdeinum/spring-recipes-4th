package com.apress.springrecipes.reactive.court;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.DispatcherHandler;
import reactor.ipc.netty.NettyContext;
import reactor.ipc.netty.http.server.HttpServer;

@Configuration
public class ReactorNettyBootstrap {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebFluxConfiguration.class)) {
            context.getBean(NettyContext.class).onClose().block();
        }
    }

    @Bean
    public NettyContext nettyContext(ApplicationContext context) {

        HttpHandler handler = DispatcherHandler.toHttpHandler(context);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
        HttpServer httpServer = HttpServer.create("localhost", 8090);
        return httpServer.newHandler(adapter).block();
    }
}
