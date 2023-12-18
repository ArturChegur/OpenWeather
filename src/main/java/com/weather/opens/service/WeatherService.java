package com.weather.opens.service;

import com.weather.opens.model.WeatherDTO;


public interface WeatherService {
    WeatherDTO getTemperature(String cityName);
}