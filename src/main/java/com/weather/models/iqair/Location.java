package com.weather.models.iqair;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class Location{
    private String type;
    private List<Double> coordinates;
}
