package dev.trung.quakereport.ui.activity;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import dev.trung.quakereport.R;
import dev.trung.quakereport.databinding.ActivitySettingsEarthQuakeBinding;
import dev.trung.quakereport.ui.fragment.EarthquakePreferenceFragment;

/**
 * Created by trungnv on 8/24/2016.
 */

public class EarthQuakeSettingsActivity extends AppCompatActivity {
    private ActivitySettingsEarthQuakeBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_earth_quake);
        if (savedInstanceState == null) {
            if (getFragmentManager().findFragmentById(R.id.framgment_settings) == null) {
                EarthquakePreferenceFragment fragment = new EarthquakePreferenceFragment();
                getFragmentManager().beginTransaction().replace(R.id.framgment_settings, fragment).commit();
            }
        }
    }
}
