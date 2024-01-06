package com.weather.opens.serviceAPI.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.weather.opens.model.WeatherDTO;
import com.weather.opens.service.impl.CityServiceImpl;
import com.weather.opens.serviceAPI.APIService;
import com.weather.opens.util.MappingUtils;


@Service
public class OpenWeatherAPI implements APIService {
    private final String ADDRESS;
    private final String TOKEN;
    private final CityServiceImpl cityService;
    private final MappingUtils mappingUtils;

    public OpenWeatherAPI(@Value("${service.openweather.address}") String ADDRESS, @Value("${service.openweather.token}") String TOKEN, CityServiceImpl cityService, MappingUtils mappingUtils) {
        this.ADDRESS = ADDRESS;
        this.TOKEN = TOKEN;
        this.cityService = cityService;
        this.mappingUtils = mappingUtils;
    }

    public WeatherDTO getDataFromAPI(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        WeatherDTO dto = mappingUtils.mapToWeatherDTO(cityService.findCityByCoordinates(cityName));
        String request = ADDRESS + "lat=" + dto.getLatitude().toString() + "&" + "lon=" + dto.getLongitude().toString() + "&appid=" + TOKEN;
        JsonNode weatherApiCall = restTemplate.getForObject(request, JsonNode.class);
        dto.setTemperature(Double.parseDouble(weatherApiCall.get("main").get("temp").toString()));
        return dto;
    }
}