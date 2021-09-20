package com.weather.api.soap.service;

import com.weather.api.ResponseProvider;
import com.weather.models.iqair.Pollution;
import com.weather.models.openweather.onecallapi.Current;
import com.weather.models.openweather.onecallapi.Daily;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "com.weather.api.soap.service.WeatherService")
public class WeatherServiceImpl implements WeatherService {
    private final ResponseProvider responseProvider;

    public WeatherServiceImpl() {
        this.responseProvider = new ResponseProvider();
    }

    @Override
    @WebMethod
    public Current getCurrentForecastByCity(String city, String units) {
        return responseProvider.getCurrentForecast(city, units);
    }

    @Override
    @WebMethod
    public String getYesterdayForecastByCity(String city) {
        return null;
    }

    @Override
    @WebMethod
    public Daily getTomorrowForecastByCity(String city, String units) {
        return responseProvider.getTomorrow(city, units);
    }

//    @Override
//    @WebMethod
//    public ArrayList<Alert> getNationalWeatherAlerts(String city, String units) {
//        return responseProvider.getNationalWeatherAlerts(city, units);
//    }

    @Override
    @WebMethod
    public Pollution getAirPollutionByIp(String city) {
        return responseProvider.getAirPollutionByIp(city);
    }

    /*@Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUserCity(User user) {

    }*/
}
