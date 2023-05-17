package fc.java.course2.part3;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherExample {
    public static void main(String[] args) {
        String apiKey="Your Key";
        String city = "Seoul";
        String urlString="https://api.openweathermap.org/data/2.5/weather?q="+
                city + "&appid=" + apiKey + "&units=metric";
        try{
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            int responseCode = connection.getResponseCode();
            if(responseCode==200){
                // 스트림(stream)의 연결
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while((inputLine=in.readLine())!=null){
                    content.append(inputLine);
                }
                in.close();
                System.out.println("content.toString() = " + content.toString());
                JsonObject weatherData = JsonParser.parseString(content.toString()).getAsJsonObject();
                JsonObject mainData = weatherData.getAsJsonObject("main");
                double temp = mainData.get("temp").getAsDouble();
                System.out.println("temp = " + temp);
                connection.disconnect();
            }
            else{
                System.out.println("x");
                //오류
            }
        }
        catch(Exception e){
            e.printStackTrace();    // 에러메세지 출력
        }
    }
}
