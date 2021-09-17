package com.weather.requests;

import com.weather.models.openweather.onecallapi.OneCallRoot;

public class OpenWeatherRequest implements Request<OneCallRoot> {

    @Override
    public OneCallRoot getResponse(String city) {
        return null;
    }
}
