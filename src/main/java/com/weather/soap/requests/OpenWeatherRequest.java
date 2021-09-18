package com.weather.soap.requests;

import com.weather.soap.models.openweather.geocodingapi.GeocodingRoot;
import com.weather.soap.models.openweather.onecallapi.OneCallRoot;
import com.weather.soap.parser.Parser;
import com.weather.settings.Settings;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class OpenWeatherRequest {


    public OneCallRoot getResponse(String city) {
        return null;
    }

    public Map<String,String> getCoordinate(String city) {

        URI uri = URI.create(Settings.LATLONSTARTURI + city + Settings.LATLONENDURI);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
        HttpResponse<String> response = null;

        Parser parser = new Parser();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        GeocodingRoot geocodingRoot = parser.parseGeocoding(response.body())[0];
        Map<String, String> coordinates = new HashMap<>();
        coordinates.put("lat", geocodingRoot.getLat());
        coordinates.put("lon", geocodingRoot.getLon());

        return coordinates;
    }


}
