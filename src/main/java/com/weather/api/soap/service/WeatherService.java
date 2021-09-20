package com.weather.api.soap.service;

import com.weather.models.iqair.Pollution;
import com.weather.models.openweather.onecallapi.Current;
import com.weather.models.openweather.onecallapi.Daily;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WeatherService {

    @WebMethod
    Current getCurrentForecastByCity(String city, String units);

    @WebMethod
    String getYesterdayForecastByCity(String city);

    @WebMethod
    Daily getTomorrowForecastByCity(String city, String units);

//    @WebMethod
//    List<Alert> getNationalWeatherAlerts(String city, String units);

    @WebMethod
    Pollution getAirPollutionByIp(String city);

    /*@WebMethod
    void saveUser(User user);

    @WebMethod
    void updateUserCity(User user);*/
}
