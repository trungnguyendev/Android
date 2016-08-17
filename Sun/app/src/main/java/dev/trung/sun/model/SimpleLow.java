package dev.trung.sun.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnv on 8/17/2016.
 */
public class SimpleLow {
    @SerializedName("fahrenheit")
    private int fahrenheit;
    @SerializedName("celsius")
    private int celsius;

    public SimpleLow() {
    }

    public int getFahrenheit() {
        return fahrenheit;
    }

    public int getCelsius() {
        return celsius;
    }
}
