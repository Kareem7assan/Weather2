package com.example.human.weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import model.Condition;
import model.Place;
import model.Weather;

/**
 * Created by human on 30/07/16.
 */
public class MyJson {
    private Condition cond;

    public Weather getParsed(String data){
       try {

           //root json object
           JSONObject jsonObject = new JSONObject(data);
            //place
                    //cord
           JSONObject coord = jsonObject.getJSONObject("coord");
           float lon = (float) coord.getDouble("lon");
           float lat = (float) coord.getDouble("lat");
                    //sys
           JSONObject sys = jsonObject.getJSONObject("sys");
           String country = sys.getString("country");
           int sunrise = sys.getInt("sunrise");
           int sunset = sys.getInt("sunset");
                    //root object
           String city = jsonObject.getString("name");
           int lastUpdate = jsonObject.getInt("dt");
           Place place = new Place();
           place.setLon(lon);
           place.setLat(lat);
           place.setCity(city);
           place.setCountry(country);
           place.setSunrise(sunrise);
           place.setSunrise(sunset);
           place.setLastupdate(lastUpdate);
           Weather weather=new Weather();
           weather.place=place;
        //weather
           //weather object parser
           JSONArray weatherArray = jsonObject.getJSONArray("weather");
           JSONObject jsonObject1 = weatherArray.getJSONObject(0);
           int id = jsonObject1.getInt("id");
           String condition = jsonObject1.getString("main");
           String description = jsonObject1.getString("description");
           String icon = jsonObject1.getString("icon");
                    //wind
           JSONObject wind = jsonObject.getJSONObject("wind");
           float speed = (float) wind.getDouble("speed");
           float deg = (float) wind.getDouble("deg");
                    //main
           JSONObject main = jsonObject.getJSONObject("main");
           float temp = (float) main.getDouble("temp");
           int pressure = main.getInt("pressure");
           int humidity = main.getInt("humidity");
           float temp_min = (float)main.getDouble("temp_min");
           float temp_max=(float)main.getDouble("temp_max");
           //clouds
           JSONObject clouds = jsonObject.getJSONObject("clouds");
           int precp = clouds.getInt("all");
           weather.cloud.setPrec(precp);
           weather.wind.setDegree(deg);
           weather.wind.setSpeed(speed);
           weather.condition.setWeatherId(id);
           weather.condition.setCondition(condition);
           weather.condition.setDescription(description);
           weather.condition.setIcon(icon);
           weather.condition.setTemprature(temp);
           weather.condition.setPressure(pressure);
           weather.condition.setHumidity(humidity);
           weather.condition.setMaxTemp(temp_max);
           weather.condition.setMinTemp(temp_min);
            return weather;

       } catch (JSONException e) {
           e.printStackTrace();
       }

   return null;
    }
}
