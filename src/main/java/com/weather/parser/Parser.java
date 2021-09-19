package com.weather.parser;

import com.google.gson.Gson;
import com.weather.models.openweather.geocodingapi.GeocodingRoot;

import java.net.http.HttpResponse;

public class Parser {

    public <T> T getResponseEntity(String response, Class<T> tClass) {
        Gson gson = new Gson();


        T responseEntity = gson.fromJson(response, tClass);


        return responseEntity;
    }

    public GeocodingRoot parseGeocoding(String json) {
        Gson gson = new Gson();

        GeocodingRoot geocodingRoot = gson.fromJson(json, GeocodingRoot[].class)[0];

        return geocodingRoot;
    }
}