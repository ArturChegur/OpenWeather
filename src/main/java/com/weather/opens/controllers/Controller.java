package com.weather.opens.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.opens.service.impl.WeatherServiceOpenWeather;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class Controller {
    private final WeatherServiceOpenWeather weatherService;
    private final ObjectMapper mapper;


    @GetMapping("/{cityName}")
    public JsonNode cityWeather(@PathVariable String cityName) throws JsonProcessingException {
        String jsonData = mapper.writeValueAsString(weatherService.getTemperature(cityName));
        return mapper.readTree(jsonData);
    }

}