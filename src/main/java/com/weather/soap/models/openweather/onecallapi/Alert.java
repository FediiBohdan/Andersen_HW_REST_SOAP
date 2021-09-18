package com.weather.soap.models.openweather.onecallapi;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Alert{
    private String sender_name;
    private String event;
    private int start;
    private int end;
    private String description;
    private List<String> tags;

}
