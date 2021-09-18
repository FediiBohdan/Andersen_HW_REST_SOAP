package com.weather.models.openweather.onecallapi;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class OneCallRoot {
    private double lat;
    private double lon;
    private String timezone;
    private String timezone_offset;
    private Current current;
    private List<Daily> daily;
    private List<Alert> alerts;

}

