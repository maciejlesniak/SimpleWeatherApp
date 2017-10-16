package pl.sparkidea.simpleweatherapp.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import pl.sparkidea.simpleweatherapp.R;
import pl.sparkidea.simpleweatherapp.data.providers.openweather.OpenWeatherConditions;
import pl.sparkidea.simpleweatherapp.data.providers.openweather.OpenWeatherResponse;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class RetrieveStationInfoData extends AsyncTask<Void, Void, OpenWeatherResponse> {

    private final Activity parentActivity;
    private final String location;
    private final String openWeatherUrlTemplate;
    private final String apiToken;
    private final OpenWeatherConditions conditions;

    private ProgressDialog progressDialog;

    public RetrieveStationInfoData(Activity parentActivity, String city) {
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

        Long dt = openWeatherResponse.getDt()*1000;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm", Locale.getDefault());


        String infoTpl = parentActivity.getResources().getString(R.string.large_text)
                .replace("{update_dt}", sdf.format(new Date(dt)))
                .replace("{ext_id}", openWeatherResponse.getCod())
                .replace("{name}", openWeatherResponse.getName())
                .replace("{longitude}", openWeatherResponse.getCoord().getLon().toString())
                .replace("{latitude}", openWeatherResponse.getCoord().getLat().toString());

        ((TextView) parentActivity.findViewById(R.id.stationInfoText)).setText(infoTpl);

    }
}
