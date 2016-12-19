package dev.trung.library.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * trung on 12/19/2016.
 */
public class Weathers {
    @SerializedName("dt_txt")
    private String dateTime;
    @SerializedName("main")
    private Main main;
    @SerializedName("weather")
    private List<Weather> weather;

    public String getDateTime() {
        return dateTime;
    }

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }
}
