package com.weather.requests;

import com.weather.models.openweather.geocodingapi.GeocodingRoot;
import com.weather.models.openweather.onecallapi.OneCallRoot;
import com.weather.parser.Parser;
import com.weather.settings.Settings;
import org.apache.http.client.utils.URIBuilder;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class OpenWeatherRequest {
    private Parser parser;
    private HttpClient client;

    public OpenWeatherRequest(Parser parser) {
        this.parser = parser;
        this.client = HttpClient.newHttpClient();
    }

    public OneCallRoot getResponse(String city) {
        URI uri = null;
        HttpResponse<String> response = null;
        OneCallRoot oneCallRoot = new OneCallRoot();

        Map<String, String> coordinates = getCoordinate(city);

        try {
            uri = new URIBuilder(Settings.ONECALL_URI)
                    .addParameter("lat", coordinates.get("lat"))
                    .addParameter("lon", coordinates.get("lon"))
                    .addParameter("exclude", "minutely,hourly")
                    .addParameter("appid", Settings.OPENWEATHER_TOKEN)
                    .build();
            System.out.println(uri.toString());
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            if (response.statusCode() == 200) {
                oneCallRoot = parser.getResponseEntity(response, OneCallRoot.class);
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return oneCallRoot;
    }

    public Map<String, String> getCoordinate(String city) {
        URI uri = null;
        HttpResponse<String> response = null;
        Map<String, String> coordinates = new HashMap<>();

        try {
            uri = new URIBuilder(Settings.LATLONSTARTURI)
                    .addParameter("q", city)
                    .addParameter("appid", Settings.OPENWEATHER_TOKEN)
                    .build();
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                GeocodingRoot geocodingRoot = parser.parseGeocoding(response.body());

                coordinates.put("lat", geocodingRoot.getLat());
                coordinates.put("lon", geocodingRoot.getLon());
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return coordinates;
    }


}
