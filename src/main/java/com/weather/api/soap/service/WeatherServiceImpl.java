package com.weather.api.soap.service;


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
    public String getNationalWeatherAlerts(String country) {
        return null;
    }

    @Override
    public String getAirPollutionByIp(String ip) {
        return null;
    }
}
