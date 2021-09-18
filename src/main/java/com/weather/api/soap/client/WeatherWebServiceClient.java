package com.weather.api.soap.client;

import com.weather.api.soap.service.WeatherService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * TODO  * Delete later
 */
public class WeatherWebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://localhost:8080/hello?wsdl");
        QName qName = new QName("http://service.weather.com/", "WeatherServiceImplService");

        Service service = Service.create(url, qName);

        WeatherService weatherService = service.getPort(WeatherService.class);

        //System.out.println(weatherService.getText("panzer"));
    }
}
