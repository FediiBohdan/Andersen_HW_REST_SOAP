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
public class Pollution {
    private Date ts;
    private int aqius;
    private String mainus;
    private int aqicn;
    private String maincn;
}
