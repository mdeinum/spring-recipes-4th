package com.apress.springrecipes.weather.config;

import com.apress.springrecipes.weather.WeatherService;
import com.apress.springrecipes.weather.WeatherServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;

@Configuration
public class WeatherConfigHTTPInvokerClient {
    
    @Bean
    public HttpInvokerProxyFactoryBean weatherService() {
        HttpInvokerProxyFactoryBean factory = new HttpInvokerProxyFactoryBean();
	factory.setServiceUrl("http://localhost:8080/httpinvoker/weather");
	factory.setServiceInterface(WeatherService.class);
	return factory;
    }

    @Bean
    public WeatherServiceClient weatherClient() { 
	WeatherServiceClient wServiceClient = new WeatherServiceClient();
	return wServiceClient;
    }
    
}
