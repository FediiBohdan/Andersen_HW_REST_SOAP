package com.weather.pojo.openweather.onecallapi;


import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class OpenWeatherRoot {
    public double lat;
    public double lon;
    public String timezone;
    public int timezone_offset;
    public Current current;
    public List<Daily> daily;
    public List<Alert> alerts;

}

