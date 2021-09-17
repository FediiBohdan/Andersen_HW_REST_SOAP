package com.weather.models.iqair;

import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
public class Pollution{
    private Date ts;
    private int aqius;
    private String mainus;
    private int aqicn;
    private String maincn;
}
