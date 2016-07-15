package dev.trung.dialog.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by trungnv on 7/15/2016.
 */

public class ToastUtil {
    public static void Toast(Context context, String ms) {
        Toast.makeText(context, ms, Toast.LENGTH_SHORT).show();
    }
}
