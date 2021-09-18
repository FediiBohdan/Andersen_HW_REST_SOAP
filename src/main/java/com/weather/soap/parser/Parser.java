package com.weather.soap.parser;

import com.google.gson.Gson;
import com.weather.models.openweather.geocodingapi.GeocodingRoot;
import com.weather.soap.models.openweather.geocodingapi.GeocodingRoot;
import com.weather.soap.models.openweather.onecallapi.OneCallRoot;
import com.weather.soap.models.iqair.IqAirRoot;

import java.net.http.HttpResponse;


public class Parser {

    public <T> T getResponseEntity(HttpResponse<String> response, Class<T> tClass) {
        Gson gson = new Gson();
        String json = response.body();

        T responseEntity = gson.fromJson(json, tClass);


        return responseEntity;
    }

    public GeocodingRoot parseGeocoding(String json) {
        Gson gson = new Gson();

        GeocodingRoot geocodingRoot = gson.fromJson(json, GeocodingRoot[].class)[0];

        return geocodingRoot;
    }
}
