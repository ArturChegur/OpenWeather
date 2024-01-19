package com.weather.opens.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weather.opens.model.WeatherDTO;
import com.weather.opens.service.impl.WeatherServiceImpl;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherServiceImpl weatherService;

    @GetMapping("/{cityName}")
    public WeatherDTO cityWeather(@PathVariable String cityName)  {
        return weatherService.getTemperature(cityName);
    }
}