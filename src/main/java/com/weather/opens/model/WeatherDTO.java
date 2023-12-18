package com.weather.opens.model;

import lombok.Data;


@Data
public class WeatherDTO {
    private String cityName;
    private Double longitude;
    private Double latitude;
    private Double temperature;
}