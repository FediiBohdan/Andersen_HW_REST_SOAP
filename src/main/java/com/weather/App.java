package com.weather;

import com.weather.soap.models.openweather.geocodingapi.GeocodingRoot;
import com.weather.soap.parser.Parser;
import com.weather.soap.models.openweather.onecallapi.OneCallRoot;
import com.weather.soap.requests.OpenWeatherRequest;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

/* Только для тестов, можно удалить потом*/
public class App {
    public static void main(String[] args) {
        String uri = "https://api.openweathermap.org/data/2.5/onecall?lat=59.937500&lon=30.308611&exclude=minutely,hourly&appid=321d98c90ceee38339013157f778c010";
        Parser parser = new Parser();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(URI.create(uri)).GET().build();
        HttpResponse<String> response = null;
        try {
            response = client
                    .send(request,
                            HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        OneCallRoot root = parser.parseOneCall(response.body());
        //System.out.println(root);

//        System.out.println(root.getDaily());
//        System.out.println(root.getDaily().get(0).getFeels_like());

        /*uri = "http://api.openweathermap.org/geo/1.0/direct?q=moscow&limit=1&appid=321d98c90ceee38339013157f778c010";

        request = HttpRequest.newBuilder(URI.create(uri)).GET().build();
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        GeocodingRoot[] geocodingRoot = parser.parseGeocoding(response.body());*/

        OpenWeatherRequest request1 = new OpenWeatherRequest();
        System.out.println(request1.getCoordinate("moscow"));
    }
}
