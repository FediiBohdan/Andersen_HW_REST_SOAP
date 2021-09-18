package com.weather.soap.models.openweather.onecallapi;

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
public class Alert {
    private String sender_name;
    private String event;
    private int start;
    private int end;
    private String description;
    private List<String> tags;
}
