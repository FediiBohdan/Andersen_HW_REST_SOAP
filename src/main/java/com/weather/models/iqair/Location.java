package com.weather.models.iqair;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Location{
    private String type;
    private List<Double> coordinates;
}
