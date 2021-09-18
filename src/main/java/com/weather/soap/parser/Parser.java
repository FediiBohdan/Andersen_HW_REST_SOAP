package com.weather.soap.parser;

import com.google.gson.Gson;
import com.weather.soap.models.openweather.geocodingapi.GeocodingRoot;
import com.weather.soap.models.openweather.onecallapi.OneCallRoot;

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

    public IqAirRoot parseIqAir(String json) {
        Gson gson = new Gson();

        IqAirRoot iqAirRoot = gson.fromJson(json, IqAirRoot.class);

        return iqAirRoot;
    }
}
