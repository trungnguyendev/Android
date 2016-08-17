package dev.trung.sun.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnv on 8/17/2016.
 */

public class Response {
    @SerializedName("forecast")
    private Forecast forecast;

    public Response() {
    }

    public Forecast getForecast() {
        return forecast;
    }

}
