package com.weather;

import com.weather.handlers.Handler;
import com.weather.models.iqair.IqAirRoot;
import com.weather.models.openweather.onecallapi.OneCallRoot;
import com.weather.parser.Parser;
import com.weather.requests.ApiRequest;


/* Только для тестов, можно удалить потом*/
public class App {
    public static void main(String[] args) {

        Handler handler = new Handler();

        /*System.out.println(handler.getDateFromTimestamp("1632128400", "10800"));
        Long time = Instant.now().getEpochSecond();
        System.out.println(time);
        System.out.println(handler.getDateFromTimestamp(Long.toString(time), "10800"));
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("UTC+3"));
        System.out.println(dateTime);
        LocalDate today = LocalDate.parse(handler.getDateFromTimestamp(Long.toString(time), "10800").substring(0,10));
        System.out.println(today);*/

        ApiRequest request = new ApiRequest(new Parser());

        OneCallRoot root = request.getOneCallResponse("moscow", "");

        System.out.println("_____________Open Weather____________");
        System.out.println(handler.getCurrentWeather(root));
        //System.out.println(handler.getNextDay(root));
        System.out.println(handler.getAlerts(root));

        IqAirRoot iqAirRoot = request.getIqAirResponse("sankt-peterburg");

        System.out.println("__________IQ AIR ____________");
        System.out.println(iqAirRoot);
    }
}