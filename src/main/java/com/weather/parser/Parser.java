package com.weather.parser;

import com.google.gson.Gson;
import com.weather.models.openweather.geocodingapi.GeocodingRoot;

import java.net.http.HttpResponse;


public class Parser {

    public <T> T getResponseEntity(HttpResponse<String> response, Class<T> tClass) {
        Gson gson = new Gson();
        String json = response.body();

        T responseEntity = gson.fromJson(json, tClass);


        return responseEntity;
    }

    /*public OneCallRoot parseOneCall(String json) {
        Gson gson = new Gson();

        OneCallRoot oneCallRoot = gson.fromJson(json, OneCallRoot.class);

        return oneCallRoot;
    }*/

    public GeocodingRoot parseGeocoding(String json) {
        Gson gson = new Gson();

        GeocodingRoot geocodingRoot = gson.fromJson(json, GeocodingRoot[].class)[0];

        return geocodingRoot;
    }

    /*public IqAirRoot parseIqAir(String json) {
        Gson gson = new Gson();

        IqAirRoot iqAirRoot = gson.fromJson(json, IqAirRoot.class);

        return iqAirRoot;
    }*/

   /* public <T> T[] getResponseEntityFromArray(HttpResponse<String> response, Class<T> tClass) {
        Gson gson = new Gson();
        String json = response.body();
        T[] responseArray = null;

        responseArray = (T[]) gson.fromJson(json, Object[].class);

        return responseArray;
    }*/
}
