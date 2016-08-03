package dev.trung.retrofit;

import android.content.Context;
import android.util.AttributeSet;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

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

        String result = Util.AssetJSONFile(context, file);

        try {
            JSONObject obj = new JSONObject(result);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
