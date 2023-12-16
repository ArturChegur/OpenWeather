package com.weather.opens.model;

import lombok.Data;


@Data
public class WeatherDTO {
    private Long id;
    private String cityName;
    private Integer longitude;
    private Integer latitude;
    private Double temperature;
}
