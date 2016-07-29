package dev.trung.readwritefile.util;

import android.util.Log;

/**
 * Created by trungnv on 7/29/2016.
 */

public class LogUtil {
    public static String TAG = "LOG_TAG";

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
