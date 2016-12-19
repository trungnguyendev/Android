package dev.trung.library.models;

import com.google.gson.annotations.SerializedName;

/**
 * trung on 12/19/2016.
 */
public class Weather {
    @SerializedName("main")
    private String main;
    @SerializedName("description")
    private String description;
    @SerializedName("icon")
    private String icon;

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
