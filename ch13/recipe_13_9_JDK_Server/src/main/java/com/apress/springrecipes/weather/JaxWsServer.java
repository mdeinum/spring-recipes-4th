package com.apress.springrecipes.weather;

import com.apress.springrecipes.weather.config.WeatherConfigJaxWsServer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class JaxWsServer {

    public static void main(String[] args) throws IOException {
        new AnnotationConfigApplicationContext(WeatherConfigJaxWsServer.class);
    }
}
