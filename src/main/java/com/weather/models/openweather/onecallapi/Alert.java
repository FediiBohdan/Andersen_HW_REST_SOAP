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
public class Alert {
    private String sender_name;
    private String event;
    private String start;
    private String end;
    private String description;
    private List<String> tags;
}
