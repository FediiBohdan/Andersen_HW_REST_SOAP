package com.weather.requests;

import com.weather.models.openweather.onecallapi.OneCallRoot;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import static org.junit.Assert.*;

public class ApiRequestTest {

    private ApiRequest apirequest;  // object Для jUnit

    @Before
    public void setUp() throws Exception {
        apirequest = new ApiRequest();
    }

    ApiRequest apiRequestMock = mock(ApiRequest.class); // А теперь object для мокито


    @Test
    public void testApiRequestNotNull() {
        assertNotNull("Obj is null", apirequest);
    }

    @Test
    public void testOneCallRoot() {
        OneCallRoot oneCallRoot = new OneCallRoot();
        when(apiRequestMock.getOneCallResponse("Odessa", "metric")).thenReturn(oneCallRoot);
    }




//    @Test
//    public void testGetIqAirResponse() {
//        when(apiRequestMock.getOneCallResponse("Odessa", "metric")).thenReturn();
//    }

    @Test
    public void testGetOneCallResponse() {

    }
    @Test
    public void testGetCoordinate() {

    }

}