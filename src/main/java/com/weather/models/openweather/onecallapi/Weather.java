package com.weather.models.openweather.onecallapi;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@Setter
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
