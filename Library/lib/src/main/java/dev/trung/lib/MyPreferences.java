package dev.trung.lib;

import android.content.SharedPreferences;
import android.os.Build;

import java.util.Map;

import dev.trung.lib.store.Preferences;


/**
 * trung on 12/16/2016.
 */

public class MyPreferences implements Preferences {
    private SharedPreferences sharedPrefs;
    private SharedPreferences.Editor editor;

    public MyPreferences(SharedPreferences preferences) {
        this.sharedPrefs = preferences;
    }


    @Override
    public Preferences putBoolean(String key, boolean val) {
        edit();
        editor.putBoolean(key, val);
        return this;
    }

    @Override
    public Preferences putInteger(String key, int val) {
        edit();
        editor.putInt(key, val);
        return this;
    }

    @Override
    public Preferences putLong(String key, Long val) {
        edit();
        editor.putLong(key, val);
        return this;
    }

    @Override
    public Preferences putFloat(String key, Float val) {
        edit();
        editor.putFloat(key, val);
        return this;
    }

    @Override
    public Preferences putString(String key, String val) {
        edit();
        editor.putString(key, val);
        return this;
    }

    @Override
    public Preferences put(Map<String, ?> vals) {
        edit();
        for (Map.Entry<String, ?> val : vals.entrySet()) {
            if (val.getValue() instanceof Boolean)
                putBoolean(val.getKey(), (Boolean) val.getValue());
            if (val.getValue() instanceof Integer)
                putInteger(val.getKey(), (Integer) val.getValue());
            if (val.getValue() instanceof Long) putLong(val.getKey(), (Long) val.getValue());
            if (val.getValue() instanceof String) putString(val.getKey(), (String) val.getValue());
            if (val.getValue() instanceof Float) putFloat(val.getKey(), (Float) val.getValue());
        }
        return this;
    }

    @Override
    public int getInteger(String key) {
        return sharedPrefs.getInt(key, 0);
    }

    @Override
    public long getLong(String key) {
        return sharedPrefs.getLong(key, 0);
    }

    @Override
    public float getFloat(String key) {
        return sharedPrefs.getFloat(key, 0);
    }

    @Override
    public String getString(String key) {
        return sharedPrefs.getString(key, "");
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return sharedPrefs.getBoolean(key, false);
    }

    @Override
    public Map<String, ?> get() {
        return sharedPrefs.getAll();
    }

    @Override
    public boolean contains(String key) {
        return sharedPrefs.contains(key);
    }

    @Override
    public void clear() {
        edit();
        editor.clear();
    }

    @Override
    public void remove(String key) {
        edit();
        editor.remove(key);
    }

    @Override
    public void flush() {
        if (editor != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                editor.apply();
            } else {
                editor.commit();
            }
            editor = null;
        }
    }

    private void edit() {
        if (editor == null) {
            editor = sharedPrefs.edit();
        }
    }
}
