package dev.trung.retrofit.model.weather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by trungnv on 8/4/2016.
 */
public class ListsWeather {

//    @SerializedName("main")
//    private List<Main> main;
//    @SerializedName("wind")
//    private List<Wind> wind;
//    @SerializedName("rain")
//    private List<Rain> rain;
    @SerializedName("weather")
    private List<Weather> weather;
    @SerializedName("dt_txt")
    private String dt_txt;

    public ListsWeather() {
    }

//    public ListsWeather(List<Main> main, List<Wind> wind, List<Rain> rain, List<Weather> weather, String dt_txt) {
//        this.main = main;
//        this.wind = wind;
//        this.rain = rain;
//        this.weather = weather;
//        this.dt_txt = dt_txt;
//    }

//    public List<Main> getMain() {
//        return main;
//    }
//
//    public void setMain(List<Main> main) {
//        this.main = main;
//    }
//
//    public List<Wind> getWind() {
//        return wind;
//    }
//
//    public void setWind(List<Wind> wind) {
//        this.wind = wind;
//    }
//
//    public List<Rain> getRain() {
//        return rain;
//    }
//
//    public void setRain(List<Rain> rain) {
//        this.rain = rain;
//    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
