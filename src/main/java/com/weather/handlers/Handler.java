package com.weather.handlers;

import com.weather.models.openweather.onecallapi.Alert;
import com.weather.models.openweather.onecallapi.Current;
import com.weather.models.openweather.onecallapi.Daily;
import com.weather.models.openweather.onecallapi.OneCallRoot;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public class Handler {

    public Current getCurrentWeather(OneCallRoot oneCallRoot) {
        Current current = oneCallRoot.getCurrent();
        String offset = oneCallRoot.getTimezone_offset();

        current.setDt(getDateFromTimestamp(current.getDt(), offset));
        current.setSunrise(getDateFromTimestamp(current.getSunrise(), offset));
        current.setSunset(getDateFromTimestamp(current.getSunset(), offset));

        return current;
    }

    public List<Alert> getAlerts(OneCallRoot oneCallRoot) throws NullPointerException {
        List<Alert> alerts = oneCallRoot.getAlerts();
        if (alerts.size() == 0) return null;
        String offset = oneCallRoot.getTimezone_offset();

        alerts.forEach(alert -> {
            alert.setEnd(getDateFromTimestamp(alert.getEnd(), offset));
            alert.setStart(getDateFromTimestamp(alert.getStart(), offset));
        });
        return alerts;
    }

    public Daily getNextDay(OneCallRoot oneCallRoot) {
        List<Daily> list = oneCallRoot.getDaily();
        String offset = oneCallRoot.getTimezone_offset();
        Daily daily = null;
        LocalDate today = LocalDate.parse(
                getDateFromTimestamp(oneCallRoot.getCurrent().getDt(), oneCallRoot.getTimezone_offset()).substring(0, 10));
        LocalDate tomorrow = null;
        for (Daily d : list) {
            tomorrow = LocalDate.parse(
                    getDateFromTimestamp(d.getDt(),
                            oneCallRoot.getTimezone_offset()).substring(0, 10));
            if (tomorrow.minusDays(1L).equals(today)) {
                daily = d;
                daily.setDt(getDateFromTimestamp(daily.getDt(), offset));
                daily.setMoonrise(getDateFromTimestamp(daily.getMoonrise(), offset));
                daily.setSunrise(getDateFromTimestamp(daily.getSunrise(), offset));
                daily.setMoonset(getDateFromTimestamp(daily.getMoonset(), offset));
                daily.setSunset(getDateFromTimestamp(daily.getSunset(), offset));
                break;
            }
        }
        return daily;
    }

    public String getDateFromTimestamp(String timestamp, String offset) {
        String date;
        long time = Long.parseLong(timestamp);
        long tzOffset = Long.parseLong(offset);

        Instant instant = Instant.ofEpochSecond(time + tzOffset);
        date = instant.toString();
        return date;
    }
}
