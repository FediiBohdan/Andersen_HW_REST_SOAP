package com.weather.soap.service;

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
    String getNationalWeatherAlerts(String country);

    @WebMethod
    String getAirPollutionByIp(String ip);
}
