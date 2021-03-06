package com.weather.models.openweather.onecallapi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@Setter
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Daily {
    private String dt;
    private String sunrise;
    private String sunset;
    private String moonrise;
    private String moonset;
    private double moon_phase;
    private Temp temp;
    private FeelsLike feels_like;
    private int pressure;
    private int humidity;
    private double dew_point;
    private double wind_speed;
    private int wind_deg;
    private double wind_gust;
    private List<Weather> weather;
    private int clouds;
    private double pop;
    private double rain;
    private double uvi;
}
