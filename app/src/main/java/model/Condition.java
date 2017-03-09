package model;

/**
 * Created by human on 29/07/16.
 */
public class Condition {
    private int weatherId;
    private String condition;
    private String description;
    private String icon;
    private float pressure;
    private float humidity;
    private double temprature;
    private float maxTemp;
    private float minTemp;

   /* public Condition(int weatherId, String condition, String description, String icon) {
        this.weatherId = weatherId;
        this.condition = condition;
        this.description = description;
        this.icon = icon;
    }

    public Condition(int weatherId, String condition, String description, String icon, float pressure, float humidity, double temprature, float maxTemp, float minTemp) {
        this.weatherId = weatherId;
        this.condition = condition;
        this.description = description;
        this.icon = icon;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temprature = temprature;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;}*/


    public double getTemprature() {
        return temprature;
    }

    public void setTemprature(double temprature) {
        this.temprature = temprature;
    }

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }


}
