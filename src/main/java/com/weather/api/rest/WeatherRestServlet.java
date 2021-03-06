package com.weather.api.rest;

import com.google.gson.Gson;
import com.weather.api.ResponseProvider;
import com.weather.db.model.User;
import com.weather.models.iqair.Pollution;
import com.weather.models.openweather.onecallapi.Alert;
import com.weather.models.openweather.onecallapi.Current;
import com.weather.models.openweather.onecallapi.Daily;
import com.weather.service.UserService;
import lombok.SneakyThrows;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = {"/weather/*"})
public class WeatherRestServlet extends HttpServlet {
    private ResponseProvider responseProvider;
    private Gson gson;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        responseProvider = new ResponseProvider();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Write command pattern to get needed information

        String format = req.getParameter("accept");
        String city = req.getParameter("city");
        String units = req.getParameter("units");
        String param = req.getParameter("time");

        if ("json".equalsIgnoreCase(format)) {
            String json = "No such type of forecast";
            switch (param) {
                case "current":
                    json = gson.toJson(responseProvider.getCurrentForecast(city, units));
                    break;
                case "tomorrow":
                    json = gson.toJson(responseProvider.getTomorrow(city, units));
                    break;
                case "alerts":
                    json = gson.toJson(responseProvider.getNationalWeatherAlerts(city, units));
                    break;
                case "pollution":
                    json = gson.toJson(responseProvider.getAirPollutionByIp(city));
                    break;
            }

            resp.getWriter().write(json);
        } else if ("xml".equalsIgnoreCase(format)) {
            StringWriter stringWriter = new StringWriter();
            stringWriter.append("No such type of forecast");
            switch (param) {
                case "current":
                    stringWriter = objectToXml(Current.class, responseProvider.getCurrentForecast(city, units));
                    break;
                case "tomorrow":
                    stringWriter = objectToXml(Daily.class, responseProvider.getTomorrow(city, units));
                    break;
                case "alerts": /* TODO inspect this case */
                    stringWriter = objectToXml(Alert.class, responseProvider.getNationalWeatherAlerts(city, units));
                    break;
                case "pollution":
                    stringWriter = objectToXml(Pollution.class, responseProvider.getAirPollutionByIp(city));
                    break;
            }
            resp.getWriter().write(String.valueOf(stringWriter));
        } else {
            resp.setStatus(400);
            resp.getWriter().write("error 400, incorrect accept format");
        }
    }

    @SneakyThrows
    public StringWriter objectToXml(Object timeClass, Object responseClass) {
        StringWriter stringWriter = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance((Class) timeClass);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(responseClass, stringWriter);
        return stringWriter;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            Short country_id = Short.parseShort("country_id");
            Long city_id = Long.parseLong("city_id");
            UserService.addUser(new User(name, email), country_id, city_id);
            resp.sendRedirect(req.getContextPath());
        } catch (Exception ex) {
            resp.setStatus(401);
            resp.getWriter().write("error 401, incorrect inserted user");
        }
        // TODO Save user with city
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(req.getParameter("user_id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String country = req.getParameter("country");
            String city = req.getParameter("city");
            User user = new User(userId, name, email, country, city);
            UserService.updateUser(user);
            resp.sendRedirect(req.getContextPath());
        } catch (Exception e) {
            resp.setStatus(401);
            resp.getWriter().write("error 401, incorrect inserted user");
        }
    }

    private String getUserId(String uri) {
        Set<String> set = new HashSet<>(Arrays.asList(uri.split("/")));
        set.remove("test");
        set.remove("");
        System.out.println(set.size());
        return set.stream().findAny().get();
    }
}
