package com.weather.opens.service.impl;

import org.springframework.stereotype.Service;

import com.weather.opens.model.WeatherDTO;
import com.weather.opens.service.WeatherService;
import com.weather.opens.serviceAPI.impl.OpenWeatherAPI;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final OpenWeatherAPI apiService;

    public WeatherDTO getTemperature(String cityName) {
        return apiService.getDataFromAPI(cityName);
    }
}