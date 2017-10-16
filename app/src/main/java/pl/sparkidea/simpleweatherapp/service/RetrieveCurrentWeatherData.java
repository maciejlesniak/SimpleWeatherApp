package pl.sparkidea.simpleweatherapp.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.Locale;

import pl.sparkidea.simpleweatherapp.R;
import pl.sparkidea.simpleweatherapp.data.providers.openweather.OpenWeatherConditions;
import pl.sparkidea.simpleweatherapp.data.providers.openweather.OpenWeatherResponse;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class RetrieveCurrentWeatherData extends AsyncTask<Void, Void, OpenWeatherResponse> {

    private final Activity parentActivity;
    private final String location;
    private final String openWeatherUrlTemplate;
    private final String apiToken;
    private final OpenWeatherConditions conditions;

    private ProgressDialog progressDialog;

    public RetrieveCurrentWeatherData(Activity parentActivity, String city) {
        this.parentActivity = parentActivity;
        this.location = city;

        Resources resources = parentActivity.getResources();
        this.openWeatherUrlTemplate = resources.getString(R.string.openweather_url_tpl_current);
        this.apiToken = resources.getString(R.string.open_weather_maps_app_id);

        this.conditions = WeatherConditionsPopulator.getWeatherConditions();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        this.progressDialog = new ProgressDialog(this.parentActivity);
        this.progressDialog.setTitle("Fetching weather data...");
        this.progressDialog.show();
    }

    @Override
    protected OpenWeatherResponse doInBackground(Void... params) {

        OpenWeatherResponse openWeatherResponse = null;
        try {
            URL url = new URL(String.format(openWeatherUrlTemplate, this.location, apiToken));
            openWeatherResponse = new HttpRequestHelper().getObject(url, OpenWeatherResponse.class);

        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }

        return openWeatherResponse;
    }

    @Override
    protected void onPostExecute(OpenWeatherResponse openWeatherResponse) {
        super.onPostExecute(openWeatherResponse);
        this.progressDialog.dismiss();

        if (openWeatherResponse == null) {
            Toast.makeText(parentActivity, parentActivity.getResources().getString(R.string.place_not_found), Toast.LENGTH_SHORT).show();
        }

        TextView locationText = (TextView) parentActivity.findViewById(R.id.locationText);
        TextView weatherIconText = (TextView) parentActivity.findViewById(R.id.weatherIconText);
        TextView realTempText = (TextView) parentActivity.findViewById(R.id.realTempText);
        TextView tempText = (TextView) parentActivity.findViewById(R.id.tempText);

        OpenWeatherConditions.Description description = this.conditions.getConditions().get(openWeatherResponse.getWeather().get(0).getId());
        int icon = R.string.weather_drizzle;
        if(description != null) {
            icon = description.getRes();
        }

        weatherIconText.setText(parentActivity.getResources().getString(icon));
        locationText.setText(String.format(Locale.getDefault(), "%s/%s", openWeatherResponse.getSys().getCountry(), openWeatherResponse.getName()));
        realTempText.setText(String.format(Locale.getDefault(), "Real feeling %.1f", openWeatherResponse.getMainInfo().getTemp()));
        tempText.setText(String.format(Locale.getDefault(), "%.0f °C", openWeatherResponse.getMainInfo().getTemp()));
    }
}
