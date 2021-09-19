package com.weather.requests;

import com.weather.models.iqair.IqAirRoot;
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


public class ApiRequest {
    private Parser parser;
    private HttpClient client;

    public ApiRequest(Parser parser) {
        this.parser = parser;
        this.client = HttpClient.newHttpClient();
    }

    public OneCallRoot getOneCallResponse(String city, String units) {
        URI uri = null;
        HttpResponse<String> response = null;
        OneCallRoot oneCallRoot = new OneCallRoot();

        if (units == null) units = "metric";

        Map<String, String> coordinates = getCoordinate(city);

        try {
            uri = new URIBuilder(Settings.ONECALL_URI)
                    .addParameter("lat", coordinates.get("lat"))
                    .addParameter("lon", coordinates.get("lon"))
                    .addParameter("exclude", "minutely,hourly")
                    .addParameter("units", units)
                    .addParameter("appid", Settings.OPENWEATHER_TOKEN)
                    .build();
            System.out.println(uri.toString());
            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            if (response.statusCode() == 200) {
                oneCallRoot = parser.getResponseEntity(response.body(), OneCallRoot.class);
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO add logger
            e.printStackTrace();
        }

        return oneCallRoot;
    }


    public IqAirRoot getIqAirResponse(String city) {
        URI uri = null;
        HttpResponse<String> response = null;
        IqAirRoot iqAirRoot = new IqAirRoot();

        Map<String, String> coordinates = getCoordinate(city);

        try {
            uri = new URIBuilder(Settings.IQAIR_URL)
                    .addParameter("lat", coordinates.get("lat"))
                    .addParameter("lon", coordinates.get("lon"))
                    .addParameter("key", Settings.IQAIR_KEY)
                    .build();


            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());


            if (response.statusCode() == 200) {
                iqAirRoot = parser.getResponseEntity(response.body(), IqAirRoot.class);
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            // TODO add logger
            e.printStackTrace();
        }

        return iqAirRoot;
    }


    private Map<String, String> getCoordinate(String city) {
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
            // TODO add logger
            e.printStackTrace();
        }

        return coordinates;
    }


}
