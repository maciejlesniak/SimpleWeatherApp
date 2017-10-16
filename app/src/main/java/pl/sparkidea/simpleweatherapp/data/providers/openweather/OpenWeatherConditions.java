package pl.sparkidea.simpleweatherapp.data.providers.openweather;

import java.util.Map;

/**
 * Created by maciejlesniak on 15/10/2017.
 */

public class OpenWeatherConditions {

    public static class Description {
        private final String meaning;
        private final String iconName;
        private final int res;

        public Description(String meaning, String iconName, int res) {
            this.meaning = meaning;
            this.iconName = iconName;
            this.res = res;
        }

        public String getMeaning() {
            return meaning;
        }

        public String getIconName() {
            return iconName;
        }

        public int getRes() {
            return res;
        }
    }


    private final Map<Integer, Description> conditions;

    public OpenWeatherConditions(Map<Integer, Description> conditions) {
        this.conditions = conditions;
    }

    public Map<Integer, Description> getConditions() {
        return conditions;
    }
}
