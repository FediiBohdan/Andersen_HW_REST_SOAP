package com.weather.models.iqair;

import lombok.Getter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Getter
@ToString
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Weather {
    private Date ts;
    private int tp;
    private int pr;
    private int hu;
    private double ws;
    private int wd;
    private String ic;
}
