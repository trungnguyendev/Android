package dev.trung.sun.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by trungnv on 8/17/2016.
 */

public class TxtForecast {
    @SerializedName("date")
    private String date;
    @SerializedName("forecastday")
    private List<TxtForecastDay> forecastDays;

    public TxtForecast() {
    }

    public String getDate() {
        return date;
    }

    public List<TxtForecastDay> getForecastDays() {
        return forecastDays;
    }
}
