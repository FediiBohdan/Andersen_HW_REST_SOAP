package com.weather.models.openweather.onecallapi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeelsLike{
    private double day;
    private double night;
    private double eve;
    private double morn;
}
