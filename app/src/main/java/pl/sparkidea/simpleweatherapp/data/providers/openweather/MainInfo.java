package pl.sparkidea.simpleweatherapp.data.providers.openweather;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by maciejlesniak on 15/10/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MainInfo {

    @JsonProperty("humidity")
    private final Float humidity;
    @JsonProperty("pressure")
    private final Float pressure;
    @JsonProperty("temp")
    private final Float temp;
    @JsonProperty("temp_max")
    private final Float maxTemp;
    @JsonProperty("temp_min")
    private final Float minTemp;

    @JsonCreator
    public MainInfo(
            @JsonProperty("humidity") Float humidity,
            @JsonProperty("pressure") Float pressure,
            @JsonProperty("temp") Float temp,
            @JsonProperty("temp_max") Float maxTemp,
            @JsonProperty("temp_min") Float minTemp) {
        this.humidity = humidity;
        this.pressure = pressure;
        this.temp = temp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }


    public Float getHumidity() {
        return humidity;
    }

    public Float getPressure() {
        return pressure;
    }

    public Float getTemp() {
        return temp;
    }

    public Float getMaxTemp() {
        return maxTemp;
    }

    public Float getMinTemp() {
        return minTemp;
    }
}
