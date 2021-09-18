package com.weather.models.openweather.onecallapi;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OneCallRoot {
    private double lat;
    private double lon;
    private String timezone;
    private int timezone_offset;
    private Current current;
    private List<Daily> daily;
    private List<Alert> alerts;
}

