package com.weather.models.iqair;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class Weather{
    private Date ts;
    private float tp;
    private float pr;
    private float hu;
    private double ws;
    private float wd;
    private String ic;
}
