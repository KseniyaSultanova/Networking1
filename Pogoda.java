package HomeWork06;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Pogoda {
    String key = "2d55ab7b1b158462720e69085077bce6";

    static String getContent(String city) {
        StringBuffer content = new StringBuffer();
        try {
            URL url1 = new URL("https://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=2d55ab7b1b158462720e69085077bce6");
            URLConnection urlConnection = url1.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    public static void main(String[] args) {
        String myCity = "Moscow";

        String jsonContent = getContent(myCity);
        System.out.println(jsonContent);
        JSONObject obj = new JSONObject(jsonContent);
        System.out.println(obj.getJSONObject("main").getDouble("temp") - 273);

    }
}




