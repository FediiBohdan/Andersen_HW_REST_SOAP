package com.weather.pojo.openweather.onecallapi;

import lombok.ToString;

import java.util.List;

@ToString
public class Alert{
    public String sender_name;
    public String event;
    public int start;
    public int end;
    public String description;
    public List<String> tags;

}
