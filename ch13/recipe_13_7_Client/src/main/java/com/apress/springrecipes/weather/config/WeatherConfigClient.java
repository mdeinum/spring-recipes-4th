package com.apress.springrecipes.weather.config;

import com.apress.springrecipes.weather.WeatherService;
import com.apress.springrecipes.weather.WeatherServiceClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiProxyFactoryBean;

@Configuration
public class WeatherConfigClient {

    @Bean
    public RmiProxyFactoryBean weatherService() {
        RmiProxyFactoryBean rmiProxy = new RmiProxyFactoryBean();
        rmiProxy.setServiceUrl("rmi://localhost:1099/WeatherService");
        rmiProxy.setServiceInterface(WeatherService.class);
        return rmiProxy;
    }

    @Bean
    public WeatherServiceClient weatherClient(WeatherService weatherService) {
        return new WeatherServiceClient(weatherService);
    }
}
