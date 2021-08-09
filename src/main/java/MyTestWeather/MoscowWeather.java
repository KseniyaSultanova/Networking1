package MyTestWeather;

import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
public class MoscowWeather {
    
    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    public static void parseCurrentWeatherJson(String resultJson) {
        try {
            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);

            System.out.println("Название города: " + weatherJsonObject.get("name"));

            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("weather");
            JSONObject weatherData = (JSONObject) weatherArray.get(0);

            System.out.println("Погода на данный момент: " + weatherData.get("main"));
            System.out.println("Более детальное описание погоды: " + weatherData.get("description"));

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }

    public static String buildWeatherJson() {
        JSONObject jsonObject = new JSONObject();


        return jsonObject.toJSONString();
    }

    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
