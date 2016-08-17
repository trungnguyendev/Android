package dev.trung.sun.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by trungnv on 8/17/2016.
 */

public class SimpleForecast {
    @SerializedName("forecastday")
    private List<SimpleForecastDay> simpleForecastDays;

    public SimpleForecast() {
    }

    public List<SimpleForecastDay> getSimpleForecastDays() {
        return simpleForecastDays;
    }

}
