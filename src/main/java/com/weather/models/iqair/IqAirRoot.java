package com.weather.models.iqair;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class IqAirRoot {
    private String status;
    private Data data;
}
