package model;

/**
 * Created by human on 29/07/16.
 */
public class Weather {


    public Place place;
    private String iconData;
    private String description;
    public Condition condition=new Condition();
   public Temprature temp= new Temprature();
    public Wind wind=new Wind();
    public Snow snow=new Snow();
    public Cloud cloud=new Cloud();
}
