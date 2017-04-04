package com.apress.springrecipes.weather.config;

import com.apress.springrecipes.weather.WeatherService;
import com.apress.springrecipes.weather.WeatherServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.jaxws.SimpleHttpServerJaxWsServiceExporter;

@Configuration
public class WeatherConfigJaxWsServer {

    @Bean
    public WeatherService weatherService() {
        return new WeatherServiceImpl();
    }

    @Bean
    public SimpleHttpServerJaxWsServiceExporter jaxWsService() {
        SimpleHttpServerJaxWsServiceExporter simpleJaxWs = new SimpleHttpServerJaxWsServiceExporter();
        simpleJaxWs.setPort(8888);
        simpleJaxWs.setBasePath("/jaxws/");
        return simpleJaxWs;
    }

}
