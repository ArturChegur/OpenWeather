package com.weather.opens.serviceAPI;

import com.weather.opens.model.WeatherDTO;


public interface APIService {
    WeatherDTO getDataFromAPI(String cityName);
}