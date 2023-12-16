package com.weather.opens.service.impl;

import org.springframework.stereotype.Service;

import com.weather.opens.repository.CityRepository;
import com.weather.opens.model.City;
import com.weather.opens.service.CityService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    public City findCityByCoordinates(String cityName) {
        return cityRepository.findCityByName(cityName);
    }

}
