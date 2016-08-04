package dev.trung.retrofit.ui.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.*;
import android.preference.MultiSelectListPreference;

import dev.trung.retrofit.R;

/**
 * Created by trungnv on 8/3/2016.
 */

public class SettingsActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.activity_settings);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Preference prefer = findPreference(s);
        if (prefer instanceof android.preference.MultiSelectListPreference) {
            MultiSelectListPreference pre = (android.preference.MultiSelectListPreference) prefer;
            pre.getValues();
        }
    }
}
