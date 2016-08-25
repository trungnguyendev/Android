package dev.trung.quakereport.ui.fragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import dev.trung.quakereport.R;

/**
 * Created by trungnv on 8/24/2016.
 */

public class EarthquakePreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_main);
        Preference magnitude = findPreference(getString(R.string.settings_min_magnitude_key));
        bindPreferenceSummaryToValue(magnitude);
        Preference limit = findPreference(getString(R.string.settings_limit_key));
        bindPreferenceSummaryToValue(limit);

    }

    private void bindPreferenceSummaryToValue(Preference preference) {
        preference.setOnPreferenceChangeListener(this);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
        String s = sharedPreferences.getString(preference.getKey(), "");
        onPreferenceChange(preference, s);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
        String value = String.valueOf(o);
        preference.setSummary(value);
        return true;
    }
}