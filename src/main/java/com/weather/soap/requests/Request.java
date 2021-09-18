package com.weather.soap.requests;

public interface Request<T> {
    T getResponse(String city);
}
