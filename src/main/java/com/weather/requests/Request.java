package com.weather.requests;

public interface Request<T> {
    T getResponse();
}
