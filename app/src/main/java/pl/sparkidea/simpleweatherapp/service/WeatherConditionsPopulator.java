package pl.sparkidea.simpleweatherapp.service;

import java.util.HashMap;
import java.util.Map;

import pl.sparkidea.simpleweatherapp.R;
import pl.sparkidea.simpleweatherapp.data.providers.openweather.OpenWeatherConditions;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class WeatherConditionsPopulator {

    public static OpenWeatherConditions getWeatherConditions() {

        Map<Integer, OpenWeatherConditions.Description> conditions = new HashMap<>();

//        Group 2xx: Thunderstorm                   icon day
//        ID	Meaning	Icon
//        200	thunderstorm with light rain	    11d
//        201	thunderstorm with rain	            11d
//        202	thunderstorm with heavy rain	    11d
//        210	light thunderstorm	                11d
//        211	thunderstorm	                    11d
//        212	heavy thunderstorm	                11d
//        221	ragged thunderstorm	                11d
//        230	thunderstorm with light drizzle	    11d
//        231	thunderstorm with drizzle	        11d
//        232	thunderstorm with heavy drizzle	    11d

        conditions.put(200, new OpenWeatherConditions.Description("thunderstorm with light rain", "11d", R.string.weather_rainy));
        conditions.put(201, new OpenWeatherConditions.Description("thunderstorm with rain", "11d", R.string.weather_rainy));
        conditions.put(202, new OpenWeatherConditions.Description("thunderstorm with heavy rain", "11d", R.string.weather_rainy));
        conditions.put(210, new OpenWeatherConditions.Description("light thunderstorm", "11d", R.string.weather_thunder));
        conditions.put(211, new OpenWeatherConditions.Description("thunderstorm", "11d", R.string.weather_thunder));
        conditions.put(212, new OpenWeatherConditions.Description("heavy thunderstorm", "11d", R.string.weather_thunder));
        conditions.put(221, new OpenWeatherConditions.Description("ragged thunderstorm", "11d", R.string.weather_thunder));
        conditions.put(230, new OpenWeatherConditions.Description("thunderstorm with light drizzle", "11d", R.string.weather_thunder));
        conditions.put(231, new OpenWeatherConditions.Description("thunderstorm with drizzle", "11d", R.string.weather_thunder));
        conditions.put(232, new OpenWeatherConditions.Description("thunderstorm with heavy drizzle", "11d", R.string.weather_thunder));

//        Group 3xx: Drizzle
//        ID	Meaning	Icon
//        300	light intensity drizzle	 09d
//        301	drizzle	 09d
//        302	heavy intensity drizzle	 09d
//        310	light intensity drizzle rain	 09d
//        311	drizzle rain	 09d
//        312	heavy intensity drizzle rain	 09d
//        313	shower rain and drizzle	 09d
//        314	heavy shower rain and drizzle	 09d
//        321	shower drizzle	 09d

//        Group 5xx: Rain
//        ID	Meaning	Icon
//        500	light rain	 10d
//        501	moderate rain	 10d
//        502	heavy intensity rain	 10d
//        503	very heavy rain	 10d
//        504	extreme rain	 10d
//        511	freezing rain	 13d
//        520	light intensity shower rain	 09d
//        521	shower rain	 09d
//        522	heavy intensity shower rain	 09d
//        531	ragged shower rain	 09d

//        Group 6xx: Snow
//        ID	Meaning	Icon
//        600	light snow	 13d
//        601	snow	 13d
//        602	heavy snow	 13d
//        611	sleet	 13d
//        612	shower sleet	 13d
//        615	light rain and snow	 13d
//        616	rain and snow	 13d
//        620	light shower snow	 13d
//        621	shower snow	 13d
//        622	heavy shower snow	 13d

//        Group 7xx: Atmosphere
//        ID	Meaning	Icon
//        701	mist	 50d
//        711	smoke	 50d
//        721	haze	 50d
//        731	sand, dust whirls	 50d
//        741	fog	 50d
//        751	sand	 50d
//        761	dust	 50d
//        762	volcanic ash	 50d
//        771	squalls	 50d
//        781	tornado	 50d

//        Group 800: Clear
//        ID	Meaning	Icon
//        800	clear sky	 01d  01n

//        Group 80x: Clouds             icons day/night
//        ID	Meaning	Icon
//        801	few clouds	            02d  02n
//        802	scattered clouds	    03d  03n
//        803	broken clouds	        04d  04n
//        804	overcast clouds	        04d  04n

        conditions.put(801, new OpenWeatherConditions.Description("few clouds", "02d", R.string.weather_cloudy));
        conditions.put(802, new OpenWeatherConditions.Description("scattered clouds", "03d", R.string.weather_cloudy));
        conditions.put(803, new OpenWeatherConditions.Description("broken clouds", "04d", R.string.weather_cloudy));
        conditions.put(804, new OpenWeatherConditions.Description("overcast clouds", "04d", R.string.weather_cloudy));

//        Group 90x: Extreme
//        ID	Meaning
//        900	tornado
//        901	tropical storm
//        902	hurricane
//        903	cold
//        904	hot
//        905	windy
//        906	hail

//        Group 9xx: Additional
//        ID	Meaning
//        951	calm
//        952	light breeze
//        953	gentle breeze
//        954	moderate breeze
//        955	fresh breeze
//        956	strong breeze
//        957	high wind, near gale
//        958	gale
//        959	severe gale
//        960	storm
//        961	violent storm
//        962	hurricane






        return new OpenWeatherConditions(conditions);
    }

}
