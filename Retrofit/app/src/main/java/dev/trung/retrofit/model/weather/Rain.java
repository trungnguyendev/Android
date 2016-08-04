package dev.trung.retrofit.model.weather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnv on 8/4/2016.
 */

public class Rain {
    @SerializedName("3h")
    private double h;

    public Rain() {
    }

    public Rain(double h) {
        this.h = h;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
