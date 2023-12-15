package com.weather.opens.serviceAPI;

import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;


@Service
public class OpenWeatherCall {
    private final String ADDRESS = "https://api.openweathermap.org/data/2.5/weather?";
    private final String TOKEN = "&appid=c451d6977f9e43648a3893e8fc66ccb4";

    public JsonNode getDataFromAPI(Integer longitude, Integer latitude) {
        RestTemplate restTemplate = new RestTemplate();
        String request = ADDRESS + "lat=" + latitude.toString() + "&" + "lon=" + longitude.toString() + TOKEN;
        JsonNode weatherApiCall = restTemplate.getForObject(request, JsonNode.class);
        return Objects.requireNonNull(weatherApiCall).get("main").get("temp");
    }

}
