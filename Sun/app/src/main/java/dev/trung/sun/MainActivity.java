package dev.trung.sun;


import android.content.Context;
import android.databinding.DataBindingUtil;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

import dev.trung.sun.data.ApiClient;
import dev.trung.sun.data.ApiWeather;
import dev.trung.sun.databinding.ActivityMainBinding;
import dev.trung.sun.model.Forecast;
import dev.trung.sun.model.SimpleForecast;
import dev.trung.sun.model.SimpleForecastDay;
import dev.trung.sun.ui.WeatherAdapter;
import dev.trung.sun.util.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<dev.trung.sun.model.Response> {
    private ActivityMainBinding mBinding;
    private final String COUNTRY = "VU";
    private WeatherAdapter mWeatherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        loadForecast();
    }

    @Override
    public void onResponse(Call<dev.trung.sun.model.Response> call, Response<dev.trung.sun.model.Response> response) {
        List<SimpleForecastDay> list = response.body().getForecast().getSimpleForecast().getSimpleForecastDays();
        SimpleForecastDay today = list.get(0);
        showDetailForecast(today);
        mWeatherAdapter = new WeatherAdapter(list, this);
        mBinding.recyclerWeather.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mBinding.recyclerWeather.setLayoutManager(manager);
        mBinding.recyclerWeather.setAdapter(mWeatherAdapter);
    }

    @Override
    public void onFailure(Call<dev.trung.sun.model.Response> call, Throwable t) {
        Toast.makeText(this, t.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void showDetailForecast(SimpleForecastDay today) {
        if (today != null) {
            mBinding.txtAddress.setText(today.getDate().getTzLong());
            mBinding.txtDateTime.setText(today.getDate().getWeekdayShort() + "-" + today.getDate().getDay() + " " + today.getDate().getMonthnameShort() + ", " + today.getDate().getYear());
            Picasso.with(this).load(today.getIconUrl()).into(mBinding.imgIcon);
            mBinding.txtConditions.setText(today.getConditions());
            mBinding.txtHigh.setText(String.valueOf(today.getHigh().getCelsius()));
            mBinding.txtLow.setText(String.valueOf(today.getLow().getCelsius()));
            mBinding.txtHumidity.setText(String.valueOf(today.getAvehumidity()) + "%");
            mBinding.txtWind.setText(String.valueOf(Utils.formatKmhFromMph(today.getAvewind().getMph())) + "km/h");
        }
    }

    private void loadForecast() {
        if (Utils.isNetworkAvailable(this)) {
            ApiWeather apiWeather = ApiClient.getClient().create(ApiWeather.class);
            Call<dev.trung.sun.model.Response> cityCall = apiWeather.loadForecast(COUNTRY);
            cityCall.enqueue(this);
        } else {
            Toast.makeText(this, "Network is not Available!", Toast.LENGTH_LONG).show();
        }
    }


}