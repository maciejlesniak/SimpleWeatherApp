package pl.sparkidea.simpleweatherapp.service;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import pl.sparkidea.simpleweatherapp.R;
import pl.sparkidea.simpleweatherapp.data.providers.openweather.OpenWeatherConditions;
import pl.sparkidea.simpleweatherapp.data.providers.openweather.OpenWeatherResponse;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class RetrieveWeatherForecastData extends AsyncTask<Void, Void, List<OpenWeatherResponse>> {

    private final Activity parentActivity;
    private final String location;
    private final String openWeatherUrlTemplate;
    private final String apiToken;
    private final OpenWeatherConditions conditions;

    private ProgressDialog progressDialog;

    public RetrieveWeatherForecastData(Activity parentActivity, String city) {
        this.parentActivity = parentActivity;
        this.location = city;

        Resources resources = parentActivity.getResources();
        this.openWeatherUrlTemplate = resources.getString(R.string.openweather_url_tpl_5d_forecast);
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
    protected List<OpenWeatherResponse> doInBackground(Void... params) {

        List<OpenWeatherResponse> forecastResponse = new ArrayList<>();
        try {
            URL url = new URL(String.format(openWeatherUrlTemplate, this.location, apiToken));
            JsonNode forecastNode = new HttpRequestHelper().getObject(url, JsonNode.class);

            Iterator<JsonNode> elements = forecastNode.get("list").elements();
            while (elements.hasNext()) {
                forecastResponse.add(new ObjectMapper().convertValue(elements.next(), OpenWeatherResponse.class));
            }

        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
        }

        return forecastResponse;
    }

    @Override
    protected void onPostExecute(List<OpenWeatherResponse> forecastResponse) {
        super.onPostExecute(forecastResponse);
        this.progressDialog.dismiss();

        if (forecastResponse == null) {
            Toast.makeText(parentActivity, parentActivity.getResources().getString(R.string.place_not_found), Toast.LENGTH_SHORT).show();
        }

        ListView weekList = (ListView)parentActivity.findViewById(R.id.weekList);
        OpenWeatherArrayAdapter openWeatherArrayAdapter = new OpenWeatherArrayAdapter(parentActivity, R.layout.forecast_list_element, forecastResponse.toArray(new OpenWeatherResponse[]{}));
        weekList.setAdapter(openWeatherArrayAdapter);
    }
}
