package com.weather.pojo.openweather;

import lombok.ToString;

@ToString
public class Weather{
    public int id;
    public String main;
    public String description;
    public String icon;
}
