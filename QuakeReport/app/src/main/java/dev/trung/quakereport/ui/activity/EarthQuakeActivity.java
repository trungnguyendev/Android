package dev.trung.quakereport.ui.activity;


import android.app.LoaderManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import dev.trung.quakereport.EarthQuakeLoader;
import dev.trung.quakereport.R;
import dev.trung.quakereport.databinding.ActivityEarthQuakeBinding;
import dev.trung.quakereport.model.EarthQuake;
import dev.trung.quakereport.ui.adapter.EarthQuakeAdapter;
import dev.trung.quakereport.util.LogUtil;
import dev.trung.quakereport.util.NetworkUtil;
import dev.trung.quakereport.util.Utils;

public class EarthQuakeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<EarthQuake>>, SwipeRefreshLayout.OnRefreshListener {
    private ActivityEarthQuakeBinding mBinding;
    private EarthQuakeAdapter mEarthQuakeAdapter;
    private static final String USGS_REQUEST_URL =
            "http://earthquake.usgs.gov/fdsnws/event/1/query";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_earth_quake);
        mBinding.list.setEmptyView(mBinding.emptyView);
        mBinding.refresh.setOnRefreshListener(this);
        mEarthQuakeAdapter = new EarthQuakeAdapter(this);
        loadEarthQuake();
        mBinding.list.setAdapter(mEarthQuakeAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_earth_quake, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, EarthQuakeSettingsActivity.class));
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public android.content.Loader<List<EarthQuake>> onCreateLoader(int i, Bundle bundle) {
        LogUtil.d("onCreateLoader");
        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String minMagnitude = sharedPrefs.getString(
                getString(R.string.settings_min_magnitude_key),
                getString(R.string.settings_min_magnitude_default));
        String limit = sharedPrefs.getString(
                getString(R.string.settings_limit_key),
                getString(R.string.settings_limit_default));
        Uri baseUri = Uri.parse(USGS_REQUEST_URL);
        Uri.Builder uriBuilder = baseUri.buildUpon();

        uriBuilder.appendQueryParameter("format", "geojson");
        uriBuilder.appendQueryParameter("limit", limit);
        uriBuilder.appendQueryParameter("minmag", minMagnitude);
        uriBuilder.appendQueryParameter("orderby", "time");

        return new EarthQuakeLoader(this, Utils.createrURL(uriBuilder.toString()));
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<EarthQuake>> loader, List<EarthQuake> earthQuakes) {
        mBinding.progressBar.setVisibility(View.GONE);
        mBinding.refresh.setRefreshing(false);
        mEarthQuakeAdapter.clear();
        if (earthQuakes != null && !earthQuakes.isEmpty()) {
            mEarthQuakeAdapter.addAll(earthQuakes);
            LogUtil.d(earthQuakes.size());
        }
        LogUtil.d("onLoadFinished");
    }

    @Override
    public void onLoaderReset(android.content.Loader<List<EarthQuake>> loader) {
        mEarthQuakeAdapter.clear();
        LogUtil.d("onLoaderReset");
    }

    @Override
    public void onRefresh() {
        mBinding.refresh.setRefreshing(true);
        if (NetworkUtil.isNetworkAvailable(this)) {
            getLoaderManager().restartLoader(0, null, this);
        } else {
            mBinding.progressBar.setVisibility(View.GONE);
            mBinding.refresh.setRefreshing(false);
            mEarthQuakeAdapter.clear();
            mBinding.emptyView.setText("No earthquakes found.");
        }
    }

    private void loadEarthQuake() {
        if (NetworkUtil.isNetworkAvailable(this)) {
            getLoaderManager().initLoader(0, null, this);
        } else {
            mBinding.progressBar.setVisibility(View.GONE);
            mBinding.emptyView.setText("No earthquakes found.");
        }
    }
}
