package pl.sparkidea.simpleweatherapp.service;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import pl.sparkidea.simpleweatherapp.R;
import pl.sparkidea.simpleweatherapp.data.providers.openweather.OpenWeatherConditions;
import pl.sparkidea.simpleweatherapp.data.providers.openweather.OpenWeatherResponse;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class OpenWeatherArrayAdapter extends ArrayAdapter<OpenWeatherResponse> {

    private final Context context;
    private final OpenWeatherResponse[] objects;
    private final OpenWeatherConditions conditions;

    public OpenWeatherArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull OpenWeatherResponse[] objects) {
        super(context, resource, objects);

        this.context = context;
        this.objects = objects;
        this.conditions = WeatherConditionsPopulator.getWeatherConditions();;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.forecast_list_element, parent, false);

        TextView iconText = (TextView) rowView.findViewById(R.id.iconText);
        Typeface weatherIconTypeFace = Typeface.createFromAsset(context.getAssets(), "fonts/weathericons-regular-webfont.ttf");
        iconText.setTypeface(weatherIconTypeFace);

        TextView dateText = (TextView) rowView.findViewById(R.id.dateText);
        TextView tempText = (TextView) rowView.findViewById(R.id.tempText);

        OpenWeatherConditions.Description description = this.conditions.getConditions().get(objects[position].getWeather().get(0).getId());
        int icon = R.string.weather_drizzle;
        if(description != null) {
            icon = description.getRes();
        }

        Long dt = objects[position].getDt()*1000;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy HH:mm", Locale.getDefault());
        dateText.setText(sdf.format(new Date(dt)));
        iconText.setText(context.getResources().getString(icon));
        tempText.setText(String.format(Locale.getDefault(), "Avg temp: %.1f °C", objects[position].getMainInfo().getTemp()));

        return rowView;


    }
}
