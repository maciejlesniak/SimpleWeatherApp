package pl.sparkidea.simpleweatherapp.data.providers.openweather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class Coord {

    @JsonProperty("lon")
    private final Float lon;
    @JsonProperty("lat")
    private final Float lat;

    @JsonCreator
    public Coord(@JsonProperty("lon") Float lon,
                 @JsonProperty("lat") Float lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public Float getLat() {
        return lat;
    }
}
