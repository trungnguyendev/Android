package dev.trung.sun;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import dev.trung.sun.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.recyclerWeather.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);
        mBinding.recyclerWeather.setLayoutManager(manager);
//        mBinding.recyclerWeather.setAdapter(adapter);
    }
}