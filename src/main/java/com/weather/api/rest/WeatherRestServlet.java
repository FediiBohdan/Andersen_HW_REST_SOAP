package com.weather.api.rest;

import com.google.gson.Gson;
import com.weather.api.ResponseProvider;
import com.weather.db.dao.CRUDDao;
import com.weather.db.dao.impl.UserDaoImpl;
import com.weather.db.model.User;
import com.weather.handlers.Handler;
import com.weather.models.openweather.onecallapi.Current;
import com.weather.models.openweather.onecallapi.OneCallRoot;
import com.weather.parser.Parser;
import com.weather.requests.ApiRequest;
import com.weather.service.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
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
        String param = req.getParameter("time");

        if ("json".equalsIgnoreCase(format)) {
            String json = "No such type of forecast";
            switch (param) {
                case "current":
                    json = gson.toJson(responseProvider.getCurrentForecast(city));
                    break;
                case "tomorrow":
                    json = gson.toJson(responseProvider.getTomorrow(city));
                    break;
                case "alerts":
                    json = gson.toJson(responseProvider.getNationalWeatherAlerts(city));
                    break;
                case "pollution":
                    json = gson.toJson(responseProvider.getAirPollutionByIp(city));
                    break;
            }

            resp.getWriter().write(json);
        } else if ("xml".equals(format)) {
            resp.getWriter().write("I don't have impl");
        } else {
            resp.setStatus(400);
            resp.getWriter().write("error 400, incorrect accept format");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              try{
                  String name = req.getParameter("name");
                  String email = req.getParameter("email");
                  String country = req.getParameter("country");
                  String city = req.getParameter("city");
                  UserService.addUser(new User(name,email,country,city));
                  resp.sendRedirect(req.getContextPath());
              }catch (Exception ex) {
                  resp.setStatus(401);
                  resp.getWriter().write("error 401, incorrect inserted user");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int userId = Integer.parseInt(req.getParameter("user_id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String country = req.getParameter("country");
            String city = req.getParameter("city");
            User user = new User(userId,name,email,country,city);
            UserService.updateUser(user);
            resp.sendRedirect(req.getContextPath());
        }catch (Exception e){
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
