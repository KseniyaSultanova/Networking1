//package MyTestWeather;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import kong.unirest.HttpResponse;
//import kong.unirest.JsonNode;
//import kong.unirest.Unirest;
//
//import java.io.IOException;
//
//
//
//public class MyTestWeather {
//
//    static private String URL =
//            "https://api.openweathermap.org/data/2.5/forecast?q=Moscow&appid=2d55ab7b1b158462720e69085077bce6"; //5day
//    ////https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=2d55ab7b1b158462720e69085077bce6" 1day
//    static private String CITY = "Moscow";
//    static private String API_KEY = "2d55ab7b1b158462720e69085077bce6";
//    static private String DAY = "dt_txt";
//    static private String TEMP = "temp";
//    static private String UNIT = "metric";
//
//
//    static private StringBuilder forecast;
//
//    public static void main(String[] args) throws IOException {
//
//        HttpResponse<JsonNode> response = Unirest.get(URL).asJson();
//
//        System.out.println(response.getBody().toString());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String MyTestWeatherFromJson = objectMapper.writeValueAsString(response.getBody().toString());
//        System.out.println(MyTestWeatherFromJson);
//
//        System.out.println("____________");
//
//        ObjectMapper objectMapper1 = new ObjectMapper();
//        com.fasterxml.jackson.databind.JsonNode date = objectMapper1
//                .readTree(MyTestWeatherFromJson)
//                .at("/list/temp/");
//        System.out.println(date.asText());
//
//        System.out.println("********");
//
//    }
//    }

