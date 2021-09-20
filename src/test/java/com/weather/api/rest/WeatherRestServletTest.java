package com.weather.api.rest;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class WeatherRestServletTest {
    private static WeatherRestServlet weatherRestServlet;
    private static HttpServletRequest req;
    private static HttpServletResponse resp;
    private static PrintWriter pw;

    @BeforeClass
    public static void  setUp() {
        weatherRestServlet = new WeatherRestServlet();
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        pw = mock(PrintWriter.class);
    }

    @Ignore
    @Test
    public void doGet() throws ServletException, IOException {
        when(req.getParameter("json")).thenReturn("json");
        when(resp.getWriter()).thenReturn(pw);
        weatherRestServlet.doGet(req, resp);

        verify(req, times(1)).getParameter("json");
        verify(req, never()).getSession();
    }

    @Test
    public void doPost() {
    }

    @Test
    public void doPut() {
    }
}