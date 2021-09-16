package com.weather.endpoint;

import com.weather.service.WeatherServiceImpl;

import javax.xml.ws.Endpoint;

public class WeatherWebServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/hello", new WeatherServiceImpl());
    }
}
