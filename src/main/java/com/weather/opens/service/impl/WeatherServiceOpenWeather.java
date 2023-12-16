package com.weather.opens.service.impl;

import org.springframework.stereotype.Service;

import com.weather.opens.model.WeatherDTO;
import com.weather.opens.service.WeatherService;
import com.weather.opens.serviceAPI.OpenWeatherAPI;
import com.weather.opens.util.MappingUtils;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class WeatherServiceOpenWeather implements WeatherService {
    private final OpenWeatherAPI apiService;
    private final CityServiceImpl cityService;
    private final MappingUtils mappingUtils;


    public WeatherDTO getTemperature(String cityName) {
        WeatherDTO dto = mappingUtils.mapToWeatherDTO(cityService.findCityByCoordinates(cityName));
        return apiService.getDataFromAPI(dto);
    }

}
