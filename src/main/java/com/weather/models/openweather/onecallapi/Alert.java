package com.weather.models.openweather.onecallapi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Alert{
    private String sender_name;
    private String event;
    private String start;
    private String end;
    private String description;
    private List<String> tags;

}
