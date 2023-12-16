package com.weather.opens.service;

import com.weather.opens.model.City;


public interface CityService {
    City findCityByCoordinates(String cityName);
}
