package com.weather.soap.endpoint;

import com.weather.soap.service.WeatherServiceImpl;

import javax.xml.ws.Endpoint;

public class WeatherWebServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/hello", new WeatherServiceImpl());
    }
}
