package com.weather.parser;

import com.google.gson.Gson;
import com.weather.models.openweather.geocodingapi.GeocodingRoot;
import com.weather.models.openweather.onecallapi.OneCallRoot;

import java.util.List;

public class Parser {

    public OneCallRoot parseOneCall(String json) {
        Gson gson = new Gson();

        OneCallRoot root = gson.fromJson(json, OneCallRoot.class);
        return root;
    }

    public GeocodingRoot[] parseGeocoding(String json) {
        Gson gson = new Gson();

        GeocodingRoot[] geocodingRoot = gson.fromJson(json, GeocodingRoot[].class);

        return geocodingRoot;
    }
}
