package com.weather.models.iqair;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Data{
    private String city;
    private String state;
    private String country;
    private Location location;
    private Current current;
}
