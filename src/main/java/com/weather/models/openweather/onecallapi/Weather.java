package com.weather.models.openweather.onecallapi;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Weather{
    private int id;
    private String main;
    private String description;
    private String icon;
}
