package com.example.human.weather;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Weather;
import utils.Utils;

public class MainActivity extends AppCompatActivity {

    private String baseUrl;
    private String city="Damietta";
    private String appId="&appid=9228c5e4462e26921161c0294ca76594";
    private TextView mCity;
    private TextView mDeg;
    private TextView mWind;
    private TextView mCloud;
    private ImageView mImg;
    private TextView mLastUpdate;
    private TextView mSunset;
    private TextView mSunrise;
    private TextView mHumidity;
    private TextView mPressure;
    Weather weather=new Weather();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         baseUrl = new Utils().BASE_URL;
         mCity = (TextView) findViewById(R.id.textView);
     mDeg=(TextView) findViewById(R.id.textView2);
       mWind =(TextView) findViewById(R.id.textView3);
       mCloud =(TextView) findViewById(R.id.textView4);
        mPressure=(TextView) findViewById(R.id.textView5);
        mHumidity= (TextView) findViewById(R.id.textView6);
        mSunrise=(TextView) findViewById(R.id.textView7);
        mSunset=(TextView) findViewById(R.id.textView8);
        mLastUpdate=(TextView) findViewById(R.id.textView9);
        mImg=(ImageView) findViewById(R.id.imageView);
        //new WeatherTask().execute();
        renderWeatherTask();
      //  new FetchImg().execute();

    }

    private void renderWeatherTask() {
        new WeatherTask().execute();
    }

    class WeatherTask extends AsyncTask<Void,Void,Weather>{

        @Override
        protected Weather doInBackground(Void... params) {
            MyHttp myHttp = new MyHttp(baseUrl, city, appId);
            String weatherData = myHttp.getWeatherData();
            MyJson parser = new MyJson();
             weather = parser.getParsed(weatherData);
         //   Log.v("data",weather.condition.getDescription());
            return weather;
        }

        @Override
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            double celsuis = weather.condition.getTemprature() - 273.15;
            String format = decimalFormat.format(celsuis);

            mCity.setText(weather.place.getCity()+","+weather.place.getCountry());
            mDeg.setText(""+format+"ْ C");
          //  SimpleDateFormat sdf = new SimpleDateFormat();
            DateFormat df = DateFormat.getTimeInstance();
           Date date = new Date(weather.place.getLastupdate());
            Date sun = new Date(weather.place.getSunrise());
            Date sun2 = new Date(weather.place.getSunset());
            String sunrise = df.format(sun);
            String format1 = df.format(date);
            String sunset = df.format(sun2);
            //String update = sdf.format(date);
            float deg = weather.wind.getSpeed();
            String desc = weather.condition.getDescription();
            float pressure = weather.condition.getPressure();
            float humidity = weather.condition.getHumidity();
            mHumidity.setText("humidity: "+humidity+"%");
            mPressure.setText("pressure: "+pressure+"hpa");
            mCloud.setText("cloud: "+desc);
            mWind.setText("wind: "+deg+" mps");
            mLastUpdate.setText("last update "+format1);
            mSunrise.setText("sunrise: "+sunrise);
            mSunset.setText("sunset: "+sunset);

        }
    }
    class FetchImg extends AsyncTask<Void,Void,Bitmap>{
        @Override
        protected Bitmap doInBackground(Void... params) {
            Bitmap fetch = fetch(weather.condition.getIcon());
            return fetch;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mImg.setImageBitmap(bitmap);
        }
       Bitmap fetch(String code){
           String url=Utils.ICON_URL+code+".png";

           try {
               Bitmap bitmap = BitmapFactory.decodeStream((InputStream) new URL(url).getContent());
               return bitmap;
           } catch (IOException e) {
               e.printStackTrace();
           }
           return null;

       };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId==R.id.city){
            showit();
        }

        return true;
    }

    private void showit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("change city");
        final EditText editText = new EditText(MainActivity.this);
        editText.setInputType(InputType.TYPE_CLASS_TEXT);
        editText.setHint("Damietta,EG");
        builder.setView(editText);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               city= editText.getText().toString();
                renderWeatherTask();
            }
        });
        builder.show();
    }
}
