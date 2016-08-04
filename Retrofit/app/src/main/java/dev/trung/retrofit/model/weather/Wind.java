package dev.trung.retrofit.model.weather;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnv on 8/4/2016.
 */

public class Wind {

    @SerializedName("speed")
    private double speed;
    @SerializedName("deg")
    private double deg;

    public Wind() {
    }

    public Wind(double speed, double deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }
}
