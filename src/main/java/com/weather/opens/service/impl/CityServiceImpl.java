package com.weather.opens.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weather.opens.repository.CityRepository;
import com.weather.opens.model.City;
import com.weather.opens.service.CityService;


@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public City findCN(String cityName) {
        return cityRepository.findCityByName(cityName);
    }

}
