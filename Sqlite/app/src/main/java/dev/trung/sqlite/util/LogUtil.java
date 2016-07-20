package dev.trung.sqlite.util;

import android.util.Log;

/**
 * Created by trungnv on 7/20/2016.
 */

public class LogUtil {
    public final static String TAG = "SQL_DEBUG";

    public static void d(Object o) {
        Log.d(TAG, String.valueOf(o));
    }

    public static void i(Object o) {
        Log.i(TAG, String.valueOf(o));
    }

    public static void e(Object o) {
        Log.e(TAG, String.valueOf(o));
    }
}
