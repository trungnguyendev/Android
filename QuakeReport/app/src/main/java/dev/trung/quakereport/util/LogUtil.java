package dev.trung.quakereport.util;

import android.util.Log;

/**
 * Created by trungnv on 8/24/2016.
 */

public class LogUtil {
    public static String LOG_TAG = "EARTH";

    public static void e(Object o) {
        Log.e(LOG_TAG, String.valueOf(o));
    }

    public static void d(Object o) {
        Log.d(LOG_TAG, String.valueOf(o));
    }

    public static void i(Object o) {
        Log.i(LOG_TAG, String.valueOf(o));
    }
}
