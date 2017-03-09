package model;

/**
 * Created by human on 29/07/16.
 */
public class Temprature
{
    /*public Temprature(double temp, float maxTemp, float minTemp) {
        this.temp = temp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }
*/
    private double temp;
    private float maxTemp;
    private float minTemp;
    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }

}
