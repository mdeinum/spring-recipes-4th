package com.apress.springrecipes.weather;

import javax.jws.WebService;
import java.util.Date;
import java.util.List;


@WebService
public interface WeatherService {

    List<TemperatureInfo> getTemperatures(String city, List<Date> dates);
}
