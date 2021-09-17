package com.weather.models.iqair;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Current{
    private Weather weather;
    private Pollution pollution;
}
