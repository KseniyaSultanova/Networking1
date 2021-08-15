package MyTestWeather;

import java.net.URL;

import MyTestWeather.entity.Weather;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class MoscowWeather {
    private DataBaseRepository dataBaseRepository = new DataBaseRepository();
    private String insertWeather2 = "insert into  weather(name,temp) values (?, ?)";
    private static final String BD_PATH = "jdbc:sqlite:geekbrains.db";
    private Weather weatherJsonObject;
    private Weather weatherMainData;


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


    public static void parseCurrentWeatherJson(String resultJson) throws SQLException {
        try {
            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);

            System.out.println("Название города: " + weatherJsonObject.get("name"));

            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("weather");
            JSONObject weatherData = (JSONObject) weatherArray.get(0);
            JSONObject weatherMainData = (JSONObject) weatherJsonObject.get("main");



            System.out.println("Погода на данный момент: " + weatherData.get("main"));
            System.out.println("Более детальное описание погоды: " + weatherData.get("description"));
            System.out.println("Детальная погода на день: " + weatherJsonObject.get("main"));
            System.out.println("Максимальная температура: " + weatherMainData.get("temp"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public void saveWeatherToDatabase2(MoscowWeather moscowWeather) throws SQLException{
        try (Connection connection = DriverManager.getConnection(BD_PATH)){
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather2);
            saveWeather.setString(1, weatherJsonObject.getCity());
            saveWeather.setInt(2, weatherMainData.getTemperature());
            saveWeather.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
