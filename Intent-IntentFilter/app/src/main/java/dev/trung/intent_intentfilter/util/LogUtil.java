package dev.trung.intent_intentfilter.util;

import android.util.Log;

/**
 * Created by trungnv on 7/12/2016.
 */

public class LogUtil {
    private static final String TAG = "INTENT_DEBUG";

    public static void i(Object obj) {
        Log.i(TAG, String.valueOf(obj));
    }

    public static void e(Object obj) {
        Log.e(TAG, String.valueOf(obj));
    }

    public static void d(Object obj) {
        Log.d(TAG, String.valueOf(obj));
    }
}
