package com.weather.models.iqair;

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
public class Location {
    private String type;
    private List<Double> coordinates;
}
