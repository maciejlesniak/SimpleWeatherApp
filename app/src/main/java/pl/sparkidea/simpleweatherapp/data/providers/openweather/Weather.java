package pl.sparkidea.simpleweatherapp.data.providers.openweather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class Weather {

    @JsonProperty("id")
    private final Integer id;
    @JsonProperty("main")
    private final String main;
    @JsonProperty("description")
    private final String description;
    @JsonProperty("icon")
    private final String icon;

    @JsonCreator
    public Weather(
            @JsonProperty("id") Integer id,
            @JsonProperty("main") String main,
            @JsonProperty("description") String description,
            @JsonProperty("icon") String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
