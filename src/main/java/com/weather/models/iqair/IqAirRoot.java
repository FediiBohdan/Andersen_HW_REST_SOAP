package com.weather.models.iqair;

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
public class IqAirRoot {
    private String status;
    private Data data;
}