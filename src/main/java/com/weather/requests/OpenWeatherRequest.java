package com.weather.requests;

import com.weather.pojo.openweather.onecallapi.OpenWeatherRoot;

public class OpenWeatherRequest implements Request<OpenWeatherRoot> {

    @Override
    public OpenWeatherRoot getResponse(String city) {
        return null;
    }
}
