package dev.trung.intent_intentfilter.util;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * Created by trungnv on 7/12/2016.
 */

public class ToastUtil {
    public static void Toast(Context context, String ms) {
        Toast.makeText(context, ms, Toast.LENGTH_SHORT).show();
    }
}
