package com.weather.opens.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String name;
    private Integer longitude;
    private Integer latitude;

}
