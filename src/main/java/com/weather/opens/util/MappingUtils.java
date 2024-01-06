package com.weather.opens.util;


import org.springframework.stereotype.Component;

import com.weather.opens.model.City;
import com.weather.opens.model.WeatherDTO;

@Component
public class MappingUtils {
    public WeatherDTO mapToWeatherDTO(City city) {
        WeatherDTO dto = new WeatherDTO();
        dto.setLatitude(city.getLatitude());
        dto.setLongitude(city.getLongitude());
        dto.setCityName(city.getName());
        return dto;
    }
}