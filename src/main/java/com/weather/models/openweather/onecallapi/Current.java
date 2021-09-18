package com.weather.models.openweather.onecallapi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Current{
    private String dt;
    private String sunrise;
    private String sunset;
    private double temp;
    private double feels_like;
    private int pressure;
    private int humidity;
    private double dew_point;
    private float uvi;
    private int clouds;
    private int visibility;
    private float wind_speed;
    private float wind_deg;
    private List<Weather> weather;
}
