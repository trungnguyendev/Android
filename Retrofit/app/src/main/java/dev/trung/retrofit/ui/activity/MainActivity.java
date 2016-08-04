package dev.trung.retrofit.ui.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import dev.trung.retrofit.R;
import dev.trung.retrofit.data.ApiClient;
import dev.trung.retrofit.data.ApiInterface;
import dev.trung.retrofit.databinding.ActivityMainBinding;
import dev.trung.retrofit.model.weather.City;
import dev.trung.retrofit.model.weather.WeathersResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements Callback<WeathersResponse> {
    private final static String API_KEY = "cb6c77d1002ae527b92d63a14351e3f8";
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<WeathersResponse> cityCall = apiInterface.getWeathers("hanoi", API_KEY, 7);
                cityCall.enqueue(this);
                Log.d("TAG", "onOptionsItemSelected");
//                Intent in = new Intent(this, SettingsActivity.class);
//                startActivity(in);
                break;
            default:
        }
        return true;
    }

    @Override
    public void onResponse(Call<WeathersResponse> call, Response<WeathersResponse> response) {
        City city = response.body().getCity();
        mBinding.txtName.setText(city.getName() + "-" + city.getCountry());
//        String a = response.body().getListsWeather().get(1).getWeather().get(0).getDescription();
        Log.d("TAG", city.getName() + " - ");
    }

    @Override
    public void onFailure(Call<WeathersResponse> call, Throwable t) {
        Log.d("TAG", "onFailure" + t.getMessage());
    }
}