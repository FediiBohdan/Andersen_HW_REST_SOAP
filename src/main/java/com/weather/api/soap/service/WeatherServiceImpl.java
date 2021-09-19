package com.weather.api.soap.service;


import com.weather.db.model.User;

import javax.jws.WebService;

@WebService(endpointInterface = "com.weather.api.soap.service.WeatherService")
public class WeatherServiceImpl implements WeatherService {


    @Override
    public String getCurrentForecastByCity(String city) {
        return null;
    }

    @Override
    public String getYesterdayForecastByCity(String city) {
        return null;
    }

    @Override
    public String getTomorrowForecastByCity(String city) {
        return null;
    }

    @Override
    public String getNationalWeatherAlerts(String city) {
        return null;
    }

    @Override
    public String getAirPollutionByIp(String city) {
        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUserCity(User user) {

    }
}
