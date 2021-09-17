package com.weather.models.openweather.geocodingapi;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class GeocodingRoot {
    private String name;
    private String lat;
    private String lon;
    private String country;
}
