package com.weather.opens.serviceAPI;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.weather.opens.model.WeatherDTO;
import com.weather.opens.service.impl.CityServiceImpl;
import com.weather.opens.util.MappingUtils;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OpenWeatherAPI implements APIService {
    @Value("${address}")
    private  String ADDRESS;
    @Value("${token}")
    private  String TOKEN;
    private final CityServiceImpl cityService;
    private final MappingUtils mappingUtils;

    public WeatherDTO getDataFromAPI(String cityName) {
        RestTemplate restTemplate = new RestTemplate();
        WeatherDTO dto = mappingUtils.mapToWeatherDTO(cityService.findCityByCoordinates(cityName));
        String request = ADDRESS + "lat=" + dto.getLatitude().toString() + "&" + "lon=" + dto.getLongitude().toString() + "&appid=" + TOKEN;
        JsonNode weatherApiCall = restTemplate.getForObject(request, JsonNode.class);
        dto.setTemperature(Double.parseDouble(weatherApiCall.get("main").get("temp").toString()));
        return dto;
    }
}