package com.weather.parser;

import com.weather.models.iqair.IqAirRoot;
import com.weather.models.openweather.onecallapi.OneCallRoot;
import com.weather.requests.ApiRequest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {
    private static String oca;
    private static String coordinate;
    private static String pollution;
    private static Parser parser;


    @BeforeClass
    public static void setUp() {
        parser = new Parser();
        oca = "{\n" +
                "    \"lat\": 59.8944,\n" +
                "    \"lon\": 30.2642,\n" +
                "    \"timezone\": \"Europe/Moscow\",\n" +
                "    \"timezone_offset\": 10800,\n" +
                "    \"current\": {\n" +
                "        \"dt\": 1632075762,\n" +
                "        \"sunrise\": 1632022575,\n" +
                "        \"sunset\": 1632067762,\n" +
                "        \"temp\": 280.23,\n" +
                "        \"feels_like\": 276.69,\n" +
                "        \"pressure\": 1026,\n" +
                "        \"humidity\": 65,\n" +
                "        \"dew_point\": 274.1,\n" +
                "        \"uvi\": 0,\n" +
                "        \"clouds\": 0,\n" +
                "        \"visibility\": 10000,\n" +
                "        \"wind_speed\": 6,\n" +
                "        \"wind_deg\": 70,\n" +
                "        \"weather\": [\n" +
                "            {\n" +
                "                \"id\": 800,\n" +
                "                \"main\": \"Clear\",\n" +
                "                \"description\": \"clear sky\",\n" +
                "                \"icon\": \"01n\"\n" +
                "            }\n" +
                "        ]\n" +
                "    }\n" +
                "}";
        coordinate = "[\n" +
                "    {\n" +
                "        \"name\": \"Moscow\",\n" +
                "        \"local_names\": {\n" +
                "            \"af\": \"Moskou\",\n" +
                "            \"ar\": \"موسكو\",\n" +
                "            \"ascii\": \"Moscow\",\n" +
                "            \"az\": \"Moskva\",\n" +
                "            \"bg\": \"Москва\",\n" +
                "            \"ca\": \"Moscou\",\n" +
                "            \"da\": \"Moskva\",\n" +
                "            \"de\": \"Moskau\",\n" +
                "            \"el\": \"Μόσχα\",\n" +
                "            \"en\": \"Moscow\",\n" +
                "            \"eu\": \"Mosku\",\n" +
                "            \"fa\": \"مسکو\",\n" +
                "            \"feature_name\": \"Moscow\",\n" +
                "            \"fi\": \"Moskova\",\n" +
                "            \"fr\": \"Moscou\",\n" +
                "            \"gl\": \"Moscova\",\n" +
                "            \"he\": \"מוסקבה\",\n" +
                "            \"hi\": \"मास्को\",\n" +
                "            \"hr\": \"Moskva\",\n" +
                "            \"hu\": \"Moszkva\",\n" +
                "            \"id\": \"Moskwa\",\n" +
                "            \"it\": \"Mosca\",\n" +
                "            \"ja\": \"モスクワ\",\n" +
                "            \"la\": \"Moscua\",\n" +
                "            \"lt\": \"Maskva\",\n" +
                "            \"mk\": \"Москва\",\n" +
                "            \"nl\": \"Moskou\",\n" +
                "            \"no\": \"Moskva\",\n" +
                "            \"pl\": \"Moskwa\",\n" +
                "            \"pt\": \"Moscovo\",\n" +
                "            \"ro\": \"Москова\",\n" +
                "            \"ru\": \"Москва\",\n" +
                "            \"sk\": \"Moskva\",\n" +
                "            \"sl\": \"Moskva\",\n" +
                "            \"sr\": \"Москва\",\n" +
                "            \"th\": \"มอสโก\",\n" +
                "            \"tr\": \"Moskova\",\n" +
                "            \"vi\": \"Mát-xcơ-va\"\n" +
                "        },\n" +
                "        \"lat\": 55.7522,\n" +
                "        \"lon\": 37.6156,\n" +
                "        \"country\": \"RU\"\n" +
                "    }\n" +
                "]";
        pollution = "{\n" +
                "    \"status\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"city\": \"Moscow\",\n" +
                "        \"state\": \"Moscow\",\n" +
                "        \"country\": \"Russia\",\n" +
                "        \"location\": {\n" +
                "            \"type\": \"Point\",\n" +
                "            \"coordinates\": [\n" +
                "                37.61556,\n" +
                "                55.75222\n" +
                "            ]\n" +
                "        },\n" +
                "        \"current\": {\n" +
                "            \"weather\": {\n" +
                "                \"ts\": \"2021-09-17T17:00:00.000Z\",\n" +
                "                \"tp\": 4,\n" +
                "                \"pr\": 1021,\n" +
                "                \"hu\": 54,\n" +
                "                \"ws\": 3.22,\n" +
                "                \"wd\": 61,\n" +
                "                \"ic\": \"04n\"\n" +
                "            },\n" +
                "            \"pollution\": {\n" +
                "                \"ts\": \"2021-09-17T19:00:00.000Z\",\n" +
                "                \"aqius\": 61,\n" +
                "                \"mainus\": \"p2\",\n" +
                "                \"aqicn\": 31,\n" +
                "                \"maincn\": \"p1\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";

    }

    @Test
    public void getResponseEntity() {
        assertTrue(parser.getResponseEntity(oca, OneCallRoot.class) != null);
        assertNotNull(parser.getResponseEntity(pollution, IqAirRoot.class).getData());
    }

    @Test
    public void parseGeocoding() {
        assertNotNull(parser.parseGeocoding(coordinate));
    }
}