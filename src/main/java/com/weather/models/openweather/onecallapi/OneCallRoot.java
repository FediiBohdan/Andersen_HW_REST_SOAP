package com.weather.models.openweather.onecallapi;


import lombok.Getter;
import lombok.ToString;

import java.util.List;
@Getter
@ToString
public class OneCallRoot {
    private double lat;
    private double lon;
    private String timezone;
    private int timezone_offset;
    private Current current;
    private List<Daily> daily;
    private List<Alert> alerts;

}

