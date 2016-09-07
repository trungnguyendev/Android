package dev.trung.music.util;

import android.util.Log;

/**
 * Created by trungnv on 9/7/2016.
 */
public class LogUtil {
    public static String TAG = "";

    public static void e(Object o) {
        Log.e(TAG, String.valueOf(o));
    }

    public static void i(Object o) {
        Log.i(TAG, String.valueOf(o));
    }

    public static void d(Object o) {
        Log.d(TAG, String.valueOf(o));
    }
}
