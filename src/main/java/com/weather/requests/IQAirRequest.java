package com.weather.requests;

import com.weather.models.iqair.IqAirRoot;
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
import java.util.Map;

public class IQAirRequest {
    private Parser parser;
    private HttpClient client;

    public IQAirRequest(Parser parser) {
        this.parser = parser;
        this.client = HttpClient.newHttpClient();
    }

    public IqAirRoot getResponse(String city) {
        OpenWeatherRequest openWeatherRequest = new OpenWeatherRequest(parser);

        URI uri = null;
        HttpResponse<String> response = null;
        IqAirRoot iqAirRoot = new IqAirRoot();

        Map<String, String> coordinates = openWeatherRequest.getCoordinate(city);

        try {
            uri = new URIBuilder(Settings.IQAIR_URL)
                    .addParameter("lat", coordinates.get("lat"))
                    .addParameter("lon", coordinates.get("lon"))
                    .addParameter("key", Settings.IQAIR_KEY)
                    .build();

            // TODO Delete
            System.out.println(uri.toString());

            HttpRequest request = HttpRequest.newBuilder(uri).GET().build();
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());

            if (response.statusCode() == 200) {
                iqAirRoot = parser.getResponseEntity(response, IqAirRoot.class);
            }
        } catch (URISyntaxException | IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return iqAirRoot;
    }
}
