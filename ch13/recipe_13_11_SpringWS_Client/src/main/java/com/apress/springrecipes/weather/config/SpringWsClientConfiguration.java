package com.apress.springrecipes.weather.config;

import com.apress.springrecipes.weather.WeatherService;
import com.apress.springrecipes.weather.WeatherServiceClient;
import com.apress.springrecipes.weather.WeatherServiceProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SpringWsClientConfiguration {


    @Bean
    public WeatherServiceClient weatherServiceClient(WeatherService weatherService) throws Exception {
        return new WeatherServiceClient(weatherService);
    }

    @Bean
    public WeatherServiceProxy weatherServiceProxy(WebServiceTemplate webServiceTemplate) throws Exception {
        return new WeatherServiceProxy(webServiceTemplate);
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setDefaultUri("http://localhost:8080/springws/services");
        return webServiceTemplate;
    }
}
