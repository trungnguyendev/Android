package dev.trung.retrofit.model.weather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by trungnv on 8/4/2016.
 */

public class WeathersResponse {
    @SerializedName("city")
    private City city;
    @SerializedName("list")
    private List<ListsWeather> listsWeather;

    public WeathersResponse() {
    }

    public WeathersResponse(City city, List<ListsWeather> listsWeather) {
        this.city = city;
        this.listsWeather = listsWeather;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<ListsWeather> getListsWeather() {
        return listsWeather;
    }

    public void setListsWeather(List<ListsWeather> listsWeather) {
        this.listsWeather = listsWeather;
    }
}
