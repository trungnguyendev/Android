package dev.trung.sun.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by trungnv on 8/17/2016.
 */

public class Utils {
    public static int formatKmhFromMph(int mph) {
        if (mph > 0)
            mph = (int) (mph * 1.609344);
        return Math.round(mph);
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }
}
