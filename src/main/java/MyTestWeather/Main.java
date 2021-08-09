package MyTestWeather;

import MyTestWeather.MoscowWeather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import java.net.URL;

public class Main {

    public static final String WEATHER_URL =
            "https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=2d55ab7b1b158462720e69085077bce6";

    public static void main(String[] args) throws JsonProcessingException {
        URL url = MyTestWeather.MoscowWeather.createUrl(WEATHER_URL);

        String resultJson = MyTestWeather.MoscowWeather.parseUrl(url);
        HttpResponse<JsonNode> response = Unirest.get(WEATHER_URL).asJson();

        System.out.println(response.getBody().toString());

        ObjectMapper objectMapper = new ObjectMapper();
        String MyTestWeatherFromJson = objectMapper.writeValueAsString(response.getBody().toString());
        System.out.println(MyTestWeatherFromJson);
        System.out.println("Полученный JSON:\n" + resultJson);

        MyTestWeather.MoscowWeather.parseCurrentWeatherJson(resultJson);



    }
}

