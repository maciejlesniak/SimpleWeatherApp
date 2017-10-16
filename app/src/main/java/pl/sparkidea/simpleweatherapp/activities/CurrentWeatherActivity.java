package pl.sparkidea.simpleweatherapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import pl.sparkidea.simpleweatherapp.R;
import pl.sparkidea.simpleweatherapp.activities.childs.AllWeekWeatherActivity;
import pl.sparkidea.simpleweatherapp.activities.childs.SettingsActivity;
import pl.sparkidea.simpleweatherapp.service.RetrieveCurrentWeatherData;

public class CurrentWeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Typeface weatherIconTypeFace = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");
        TextView weatherIconText = (TextView) findViewById(R.id.weatherIconText);
        assert weatherIconText != null;
        weatherIconText.setTypeface(weatherIconTypeFace);

        Button buttonSeeAllWeek = (Button) findViewById(R.id.buttonSeeAllWeek);
        assert buttonSeeAllWeek != null;
        buttonSeeAllWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CurrentWeatherActivity.this, AllWeekWeatherActivity.class));
            }
        });

        Button buttonSettings = (Button) findViewById(R.id.buttonSettings);
        assert buttonSettings != null;
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CurrentWeatherActivity.this, SettingsActivity.class));
            }
        });

    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String prefLocation = preferences.getString("example_text", "PL/Warsaw");

        new RetrieveCurrentWeatherData(this, prefLocation).execute();

    }
}
