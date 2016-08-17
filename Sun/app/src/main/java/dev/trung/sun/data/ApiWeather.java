package dev.trung.sun.data;

import dev.trung.sun.model.Forecast;
import dev.trung.sun.model.Response;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by trungnv on 8/16/2016.
 */


public interface ApiWeather {
    @GET("9c6d3bccd75c99b0/forecast10day/lang:{countryCode}/q/autoip.json")
    Call<Response> loadForecast(@Path("countryCode") String countryCode);
}
