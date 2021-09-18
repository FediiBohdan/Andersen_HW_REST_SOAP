package com.weather.soap.models.openweather.geocodingapi;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Getter
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GeocodingRoot {
    private String name;
    private String lat;
    private String lon;
    private String country;
}