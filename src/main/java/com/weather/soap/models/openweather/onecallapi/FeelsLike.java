package com.weather.soap.models.openweather.onecallapi;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class FeelsLike{
    private double day;
    private double night;
    private double eve;
    private double morn;
}
