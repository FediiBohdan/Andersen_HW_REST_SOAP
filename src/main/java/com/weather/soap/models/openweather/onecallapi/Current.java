package com.weather.soap.models.openweather.onecallapi;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Current{
    private int dt;
    private int sunrise;
    private int sunset;
    private double temp;
    private double feels_like;
    private int pressure;
    private int humidity;
    private double dew_point;
    private float uvi;
    private int clouds;
    private int visibility;
    private int wind_speed;
    private int wind_deg;
    private List<Weather> weather;
}
