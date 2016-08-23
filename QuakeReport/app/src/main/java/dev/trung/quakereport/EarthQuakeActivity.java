package dev.trung.quakereport;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import dev.trung.quakereport.databinding.ActivityEarthQuakeBinding;
import dev.trung.quakereport.listener.ResponseJsonListener;
import dev.trung.quakereport.model.EarthQuake;
import dev.trung.quakereport.ui.EarthQuakeAdapter;
import dev.trung.quakereport.util.Utils;

public class EarthQuakeActivity extends AppCompatActivity implements ResponseJsonListener {
    private ActivityEarthQuakeBinding mBinding;
    public static final String LOG_TAG = EarthQuakeActivity.class.getName();
    private static final String USGS_REQUEST_URL =
            "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2012-01-01&endtime=2012-12-01&minmagnitude=6";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_earth_quake);

        ArrayList<EarthQuake> earthQuakes = new ArrayList<EarthQuake>();
        earthQuakes.add(new EarthQuake("4.1", "San Francisco", "", "August 23, 2016", "3:00 PM"));
        earthQuakes.add(new EarthQuake("1.5", "London", "", "August 23, 2016", "3:00 PM"));
        earthQuakes.add(new EarthQuake("7.1", "Tokyo", "", "August 23, 2016", "3:00 PM"));
        earthQuakes.add(new EarthQuake("4.2", "Mexico City", "", "August 23, 2016", "3:00 PM"));
        earthQuakes.add(new EarthQuake("5.6", "Paris", "", "August 23, 2016", "3:00 PM"));
        earthQuakes.add(new EarthQuake("6.8", "Moscow", "", "August 23, 2016", "3:00 PM"));

        EarthQuakeAdapter adapter = new EarthQuakeAdapter(this, earthQuakes);

        mBinding.list.setAdapter(adapter);

        EarthQuakeAsync async = new EarthQuakeAsync(this);
        async.execute(Utils.createrURL(USGS_REQUEST_URL));
    }

    @Override
    public void responseJson(String result) {
        Log.d("TAG", result);
    }
}
