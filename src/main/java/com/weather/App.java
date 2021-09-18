package com.weather;

import com.weather.models.iqair.IqAirRoot;
import com.weather.parser.Parser;
import com.weather.models.openweather.onecallapi.OneCallRoot;
import com.weather.requests.IQAirRequest;
import com.weather.requests.OpenWeatherRequest;




/* Только для тестов, можно удалить потом*/
public class App {
    public static void main(String[] args) {
        String uri = "https://api.openweathermap.org/data/2.5/onecall?lat=59.937500&lon=30.308611&exclude=minutely,hourly&appid=321d98c90ceee38339013157f778c010";

        OpenWeatherRequest request = new OpenWeatherRequest(new Parser());


        OneCallRoot root = request.getResponse("moscow");

        System.out.println("_____________Open Weather____________");
        System.out.println(root.getAlerts());

        IQAirRequest iqAirRequest = new IQAirRequest(new Parser());
        IqAirRoot iqAirRoot= iqAirRequest.getResponse("sankt-peterburg");

        System.out.println("__________IQ AIR ____________");
        System.out.println(iqAirRoot);


        //System.out.println(request.getCoordinate("moscow"));

    }
}
