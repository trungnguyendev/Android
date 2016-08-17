package dev.trung.sun.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnv on 8/17/2016.
 */
public class TxtForecastDay {
    @SerializedName("icon")
    private String icon;
    @SerializedName("icon_url")
    private String iconUrl;
    @SerializedName("title")
    private String title;
    @SerializedName("fcttext")
    private String fcttext;
    @SerializedName("fcttext_metric")
    private String fcttextMetric;

    public TxtForecastDay() {
    }

    public String getIcon() {
        return icon;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getFcttext() {
        return fcttext;
    }

    public String getFcttextMetric() {
        return fcttextMetric;
    }
}
