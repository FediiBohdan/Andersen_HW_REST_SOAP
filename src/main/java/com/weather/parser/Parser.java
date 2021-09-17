package com.weather.parser;

import com.google.gson.Gson;
import com.weather.models.openweather.onecallapi.OneCallRoot;

public class Parser {
    public OneCallRoot parse(String json) {
        Gson gson = new Gson();

        OneCallRoot root = gson.fromJson(json, OneCallRoot.class);
        return root;
    }
}
