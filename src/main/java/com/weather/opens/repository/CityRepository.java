package com.weather.opens.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.weather.opens.model.City;


@Repository
public interface CityRepository extends CrudRepository<City,Long> {
    City findCityByName(String cityName);
}
