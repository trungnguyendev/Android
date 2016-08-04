package dev.trung.retrofit;

import android.content.Context;
import android.util.AttributeSet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import dev.trung.retrofit.model.Citi;
import dev.trung.retrofit.util.Util;

/**
 * Created by trungnv on 8/3/2016.
 */

public class MultiSelectListPreference extends android.preference.MultiSelectListPreference {
    private List<CharSequence> entries;
    private List<CharSequence> entriesValues;
    private String file = "city.list.json";

    public MultiSelectListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        entries = new ArrayList<CharSequence>();
        entriesValues = new ArrayList<CharSequence>();
        getCities(context);
        this.setEntries(entries.toArray(new CharSequence[entries.size()]));
        this.setEntryValues(entriesValues.toArray(new CharSequence[entriesValues.size()]));
    }

    private List<Citi> getCities(Context context) {
        List<Citi> mCities = new ArrayList<Citi>();
        String json = Util.AssetJSONFile(context, "city.list.json");
        Gson gson = new GsonBuilder().create();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray jsonElements = jsonObject.getJSONArray("citys");
            for (int i = 0; i < jsonElements.length(); i++) {
                Citi city = gson.fromJson(jsonElements.getString(i), Citi.class);
                mCities.add(city);
                entries.add(new String(city.getName()));
                entriesValues.add(new String(String.valueOf(city.get_id())));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return mCities;
        }
        return mCities;
    }
}
