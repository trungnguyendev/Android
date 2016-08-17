package dev.trung.sun.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnv on 8/17/2016.
 */
public class SimpleForecastDay {
    @SerializedName("date")
    private SimpleDate date;
    @SerializedName("high")
    private SimpleHigh high;
    @SerializedName("low")
    private SimpleLow low;
    @SerializedName("conditions")
    private String conditions;
    @SerializedName("icon_url")
    private String iconUrl;
    @SerializedName("avehumidity")
    private int avehumidity;
    @SerializedName("avewind")
    private SimpleWind avewind;

    public SimpleForecastDay() {
    }

    public SimpleDate getDate() {
        return date;
    }

    public SimpleHigh getHigh() {
        return high;
    }

    public SimpleLow getLow() {
        return low;
    }

    public String getConditions() {
        return conditions;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public int getAvehumidity() {
        return avehumidity;
    }

    public SimpleWind getAvewind() {
        return avewind;
    }
}
