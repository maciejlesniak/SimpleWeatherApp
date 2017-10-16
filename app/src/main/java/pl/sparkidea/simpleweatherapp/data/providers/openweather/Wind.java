package pl.sparkidea.simpleweatherapp.data.providers.openweather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class Wind {

    @JsonProperty("speed")
    private final Float speed;
    @JsonProperty("deg")
    private final Integer deg;

    @JsonCreator
    public Wind(@JsonProperty("speed") Float speed,
                @JsonProperty("deg") Integer deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public Float getSpeed() {
        return speed;
    }

    public Integer getDeg() {
        return deg;
    }
}
