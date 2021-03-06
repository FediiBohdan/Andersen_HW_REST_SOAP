package com.weather.api;

import com.weather.db.model.User;
import com.weather.handlers.Handler;
import com.weather.models.iqair.IqAirRoot;
import com.weather.models.iqair.Pollution;
import com.weather.models.openweather.onecallapi.Alert;
import com.weather.models.openweather.onecallapi.Current;
import com.weather.models.openweather.onecallapi.Daily;
import com.weather.parser.Parser;
import com.weather.requests.ApiRequest;

import java.util.List;

public class ResponseProvider {
    private Handler handler;
    private Parser parser;
    private ApiRequest apiRequest;

    public ResponseProvider() {
        this.handler = new Handler();
        this.parser = new Parser();
        this.apiRequest = new ApiRequest(parser);
    }

    /**
     * Method for authorized user
     */
    // TODO change accepted parameter, if you need
    public Current getCurrentForecast(int userId) {
        return null;
    }

    /**
     * Method for unauthorized user
     */
    public Current getCurrentForecast(String city, String units) {
        return handler.getCurrentWeather(apiRequest.getOneCallResponse(city, units));
    }

    public Daily getTomorrow(String city, String units) {
        return handler.getNextDay(apiRequest.getOneCallResponse(city, units));
    }

    public List<Alert> getNationalWeatherAlerts(String city, String units) {
        return handler.getAlerts(apiRequest.getOneCallResponse(city, units));
    }

    public Pollution getAirPollutionByIp(String city) {
        IqAirRoot iqAirRoot = apiRequest.getIqAirResponse(city);
        Pollution pollution = iqAirRoot.getData().getCurrent().getPollution();
        return pollution;
    }

    // TODO write save method
    public void saveUser(User user) {

    }

    // TODO write update city method
    public void updateUserCity(User user) {

    }

    @Deprecated
    public String getYesterdayForecastByCity(String city) {
        return null;
    }
}
