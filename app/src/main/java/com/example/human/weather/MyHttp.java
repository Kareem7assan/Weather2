package com.example.human.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by human on 30/07/16.
 */
public class MyHttp {
    private String url;
    private String weatherId;
    private String city;
    public MyHttp(String url, String city, String weatherId) {
    this.url=url;
    this.city=city;
    this.weatherId=weatherId;
    }

    public String getWeatherData() {
        String fullUrl=url+city+weatherId;
        try {
            URL my_url = new URL(fullUrl);
            HttpURLConnection connection = (HttpURLConnection) my_url.openConnection();
            InputStreamReader ins = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(ins);
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while((line=bufferedReader.readLine())!=null){
                stringBuilder.append(line);


            }
          return   stringBuilder.toString();

        } catch (MalformedURLException e) {


        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }
}
