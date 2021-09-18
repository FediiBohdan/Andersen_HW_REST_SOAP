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
public class Current {
    private int dt;
    private int sunrise;
    private int sunset;
    private double temp;
    private double feels_like;
    private int pressure;
    private int humidity;
    private double dew_point;
    private float uvi;
    private int clouds;
    private int visibility;
    private int wind_speed;
    private int wind_deg;
    private List<Weather> weather;
}
