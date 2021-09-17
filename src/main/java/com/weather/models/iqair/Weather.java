package com.weather.models.iqair;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class Weather{
    private Date ts;
    private int tp;
    private int pr;
    private int hu;
    private double ws;
    private int wd;
    private String ic;
}
