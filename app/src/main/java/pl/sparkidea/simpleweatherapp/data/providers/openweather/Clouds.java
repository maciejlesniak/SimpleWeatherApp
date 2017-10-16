package pl.sparkidea.simpleweatherapp.data.providers.openweather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class Clouds {
    @JsonProperty("all")
    private final Integer all;

    @JsonCreator
    public Clouds(@JsonProperty("all") Integer all) {
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }
}
