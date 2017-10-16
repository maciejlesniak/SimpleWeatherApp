package pl.sparkidea.simpleweatherapp.data.providers.openweather;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by maciejlesniak on 14/10/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenWeatherResponse {

    @JsonProperty("coord")
    private final Coord coord;
    @JsonProperty("weather")
    private final List<Weather> weather;
    @JsonProperty("base")
    private final String base;
    @JsonProperty("main")
    private final MainInfo mainInfo;
    @JsonProperty("visibility")
    private final Integer visibility;
    @JsonProperty("wind")
    private final Wind wind;
    @JsonProperty("clouds")
    private final Clouds clouds;
    @JsonProperty("dt")
    private final Long dt;
    @JsonProperty("sys")
    private final Sys sys;
    @JsonProperty("id")
    private final String id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("cod")
    private final String cod;

    @JsonCreator
    public OpenWeatherResponse(@JsonProperty("coord") Coord coord,
                               @JsonProperty("weather") List<Weather> weather,
                               @JsonProperty("base") String base,
                               @JsonProperty("main") MainInfo mainInfo,
                               @JsonProperty("visibility") Integer visibility,
                               @JsonProperty("wind") Wind wind,
                               @JsonProperty("clouds") Clouds clouds,
                               @JsonProperty("dt") Long dt,
                               @JsonProperty("sys") Sys sys,
                               @JsonProperty("id") String id,
                               @JsonProperty("name") String name,
                               @JsonProperty("cod") String cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.mainInfo = mainInfo;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Long getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCod() {
        return cod;
    }
}
