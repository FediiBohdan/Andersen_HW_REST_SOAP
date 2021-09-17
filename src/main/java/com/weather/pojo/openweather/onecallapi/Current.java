package com.weather.pojo.openweather.onecallapi;

import lombok.ToString;

import java.util.List;

@ToString
public class Current{
    public int dt;
    public int sunrise;
    public int sunset;
    public double temp;
    public double feels_like;
    public int pressure;
    public int humidity;
    public double dew_point;
    public float uvi;
    public int clouds;
    public int visibility;
    public int wind_speed;
    public int wind_deg;
    public List<Weather> weather;
}
