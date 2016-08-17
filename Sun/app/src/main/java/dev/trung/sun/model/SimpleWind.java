package dev.trung.sun.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnv on 8/17/2016.
 */
public class SimpleWind {
    @SerializedName("mph")
    private int mph;

    public SimpleWind() {
    }

    public int getMph() {
        return mph;
    }
}
