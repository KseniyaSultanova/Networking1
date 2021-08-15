package MyTestWeather.entity;

public class Weather {
    private String city;
    private int temperature;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Weather(String city, int temperature) {
        this.city = city;
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
