package pl.sparkidea.simpleweatherapp.data.providers.openweather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maciejlesniak on 15/10/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Sys {

    @JsonProperty("type")
    private final Integer type;
    @JsonProperty("id")
    private final Integer id;
    @JsonProperty("message")
    private final Float message;
    @JsonProperty("country")
    private final String country;
    @JsonProperty("sunrise")
    private final Long sunrise;
    @JsonProperty("sunset")
    private final Long sunset;

    @JsonCreator
    public Sys(
            @JsonProperty("type") Integer type,
            @JsonProperty("id") Integer id,
            @JsonProperty("message") Float message,
            @JsonProperty("country") String country,
            @JsonProperty("sunrise") Long sunrise,
            @JsonProperty("sunset") Long sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public Integer getType() {
        return type;
    }

    public Integer getId() {
        return id;
    }

    public Float getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public Long getSunset() {
        return sunset;
    }
}
