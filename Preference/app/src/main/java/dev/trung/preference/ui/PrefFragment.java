package dev.trung.preference.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.trung.preference.R;

/**
 * Created by trungnv on 7/28/2016.
 */

public class PrefFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public PrefFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.mypreference);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        Preference pref = findPreference(s);
        if (pref instanceof EditTextPreference) {
            EditTextPreference edt = (EditTextPreference) pref;
            pref.setSummary(edt.getText().toString().trim());
        }
        if (pref instanceof CheckBoxPreference) {
            CheckBoxPreference check = (CheckBoxPreference) pref;
            if (check.isChecked()) {
                check.setSummary("check");
            } else {
                check.setSummary("un check");
            }
        }
    }
}
