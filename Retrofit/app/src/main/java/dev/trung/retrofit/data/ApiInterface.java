package dev.trung.retrofit.data;

import dev.trung.retrofit.model.weather.WeathersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by trungnv on 8/4/2016.
 */

public interface ApiInterface {

    @GET("forecast")
    Call<WeathersResponse> getWeathers(@Query("q") String nameCity, @Query("APPID") String apiKey, @Query("cnt") int size);
}
