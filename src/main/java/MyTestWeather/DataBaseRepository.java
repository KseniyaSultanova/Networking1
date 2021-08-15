package MyTestWeather;

import MyTestWeather.entity.Weather;

import java.sql.*;

public class DataBaseRepository {

    private String insertWeather = "insert into  weather(city,temperature) values (?, ?)";
    private static final String BD_PATH = "jdbc:sqlite:geekbrains.db";


    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void saveWeatherToDatabase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(BD_PATH)){

            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            saveWeather.setString(1, weather.getCity());
            saveWeather.setInt(2, weather.getTemperature());
            saveWeather.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public static void main(String[] args) throws SQLException{
        DataBaseRepository dataBaseRepository2 = new DataBaseRepository();
    }
}
