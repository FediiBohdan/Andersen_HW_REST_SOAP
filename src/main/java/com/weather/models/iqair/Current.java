package com.weather.models.iqair;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Current{
    private Weather weather;
    private Pollution pollution;
}
