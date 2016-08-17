package dev.trung.sun.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by trungnv on 8/17/2016.
 */

public class Forecast {
    @SerializedName("simpleforecast")
    private SimpleForecast simpleForecast;
    @SerializedName("txt_forecast")
    private TxtForecast txtForecast;

    public Forecast() {
    }

    public SimpleForecast getSimpleForecast() {
        return simpleForecast;
    }


    public TxtForecast getTxtForecast() {
        return txtForecast;
    }

    public void setTxtForecast(TxtForecast txtForecast) {
        this.txtForecast = txtForecast;
    }
}
