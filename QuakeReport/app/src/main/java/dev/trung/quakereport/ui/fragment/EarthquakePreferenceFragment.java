package dev.trung.quakereport.ui.fragment;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

import dev.trung.quakereport.R;

/**
 * Created by trungnv on 8/24/2016.
 */

public class EarthquakePreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_main);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        String value = String.valueOf(o);
        preference.setSummary(value);
        return true;
    }
}