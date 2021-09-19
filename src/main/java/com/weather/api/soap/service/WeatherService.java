package com.weather.api.soap.service;

import com.weather.db.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WeatherService {

    @WebMethod
    String getCurrentForecastByCity(String city);

    @WebMethod
    String getYesterdayForecastByCity(String city);

    @WebMethod
    String getTomorrowForecastByCity(String city);

    @WebMethod
    String getNationalWeatherAlerts(String city);

    @WebMethod
    String getAirPollutionByIp(String city);

    @WebMethod
    void saveUser(User user);

    @WebMethod
    void updateUserCity(User user);
}
