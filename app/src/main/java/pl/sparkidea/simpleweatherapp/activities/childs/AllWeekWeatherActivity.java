package pl.sparkidea.simpleweatherapp.activities.childs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import pl.sparkidea.simpleweatherapp.R;
import pl.sparkidea.simpleweatherapp.service.RetrieveWeatherForecastData;

public class AllWeekWeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_week_weather);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String prefLocation = preferences.getString("example_text", "PL/Warsaw");

        new RetrieveWeatherForecastData(this, prefLocation).execute();
    }
}
