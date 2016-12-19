package dev.trung.library.models;

import com.google.gson.annotations.SerializedName;

/**
 * trung on 12/19/2016.
 */
public class Main {
    @SerializedName("temp")
    private String temp;
    @SerializedName("temp_min")
    private String tempMin;
    @SerializedName("temp_max")
    private String tempMax;
    @SerializedName("humidity")
    private String humidity;

    public String getTemp() {
        return temp;
    }

    public String getTempMin() {
        return tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public String getHumidity() {
        return humidity;
    }
}
