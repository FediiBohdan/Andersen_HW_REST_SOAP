package com.weather.parser;

import com.google.gson.Gson;
import com.weather.pojo.openweather.OpenWeatherRoot;

public class Parser {
    public OpenWeatherRoot parse(String json) {
        Gson gson = new Gson();

        OpenWeatherRoot root = gson.fromJson(json, OpenWeatherRoot.class);
        return root;
    }
}
