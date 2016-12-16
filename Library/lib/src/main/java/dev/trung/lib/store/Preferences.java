package dev.trung.lib.store;


import java.util.Map;

/**
 * trung on 12/16/2016.
 */

public interface Preferences {
    Preferences putBoolean(String key, boolean val);

    Preferences putInteger(String key, int val);

    Preferences putLong(String key, Long val);

    Preferences putFloat(String key, Float val);

    Preferences putString(String key, String val);

    Preferences put(Map<String, ?> vals);

    int getInteger(String key);

    long getLong(String key);

    float getFloat(String key);

    String getString(String key);

    boolean getBoolean(String key, boolean defValue);

    /**
     * Returns a read only Map<String, Object> with all the key, objects of the preferences.
     */
    Map<String, ?> get();

    public boolean contains(String key);

    public void clear();

    public void remove(String key);

    /**
     * Makes sure the preferences are persisted.
     */
    public void flush();
}
