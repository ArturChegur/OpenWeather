package com.weather.opens.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.weather.opens.service.WeatherService;


@RestController
@RequestMapping("/weather")
public class Controller {
    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{cityName}")
    public JsonNode cityWeather(@PathVariable String cityName) {
        System.out.println(cityName);
        return weatherService.getTemperature(cityName);
    }

}
