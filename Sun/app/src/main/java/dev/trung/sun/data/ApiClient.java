package dev.trung.sun.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by trungnv on 8/16/2016.
 */

public class ApiClient {
    public static final String BASE_URL = "http://api.wunderground.com/api/";
    private static Retrofit retrofit = null;
    private static Gson gson = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return retrofit;
    }
}
