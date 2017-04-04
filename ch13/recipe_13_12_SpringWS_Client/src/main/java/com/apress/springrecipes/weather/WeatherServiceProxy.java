package com.apress.springrecipes.weather;

import org.springframework.ws.client.core.WebServiceTemplate;

import java.util.Date;
import java.util.List;

public class WeatherServiceProxy implements WeatherService {

    private WebServiceTemplate webServiceTemplate;

    public WeatherServiceProxy(WebServiceTemplate webServiceTemplate) throws Exception {
        this.webServiceTemplate = webServiceTemplate;
    }

    public List<TemperatureInfo> getTemperatures(String city, List<Date> dates) {

        GetTemperaturesRequest request = new GetTemperaturesRequest(city, dates);
        GetTemperaturesResponse response = (GetTemperaturesResponse) this.webServiceTemplate.marshalSendAndReceive(request);
        return response.getTemperatures();
    }
}
