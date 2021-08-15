package MyTestWeather;

import MyTestWeather.MoscowWeather;
import MyTestWeather.entity.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;


public class Main {

    public static final String WEATHER_URL =
            "https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=2d55ab7b1b158462720e69085077bce6";
    //МОЙ АПИ "https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=2d55ab7b1b158462720e69085077bce6";
    public static void main(String[] args) throws JsonProcessingException, SQLException {
        URL url = MoscowWeather.createUrl(WEATHER_URL);

        String resultJson = MoscowWeather.parseUrl(url);
        HttpResponse<JsonNode> response = Unirest.get(WEATHER_URL).asJson();

       System.out.println(response.getBody().toString());

        ObjectMapper objectMapper = new ObjectMapper();
        String MyTestWeatherFromJson = objectMapper.writeValueAsString(response.getBody().toString());
        System.out.println(MyTestWeatherFromJson);
        System.out.println("Полученный JSON:\n" + resultJson);
        MoscowWeather.parseCurrentWeatherJson(resultJson);

    }
}


