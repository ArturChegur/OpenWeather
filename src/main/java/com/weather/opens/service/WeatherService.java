package com.weather.opens.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.weather.opens.service.impl.CityServiceImpl;
import com.weather.opens.serviceAPI.OpenWeatherCall;
import com.weather.opens.model.City;


@Service
public class WeatherService {
    @Autowired
    private OpenWeatherCall apiService;
    @Autowired
    private CityServiceImpl cityService;

    public JsonNode getTemperature(String cityName) {
        City currentCity = cityService.findCN(cityName);
        return apiService.getDataFromAPI(currentCity.getLongitude(), currentCity.getLatitude());
    }

}
