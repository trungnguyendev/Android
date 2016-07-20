package dev.trung.sqlite.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by trungnv on 7/20/2016.
 */

public class ToastUtil {
    public static void Toast(Context context, Object o) {
        Toast.makeText(context, String.valueOf(o), Toast.LENGTH_SHORT).show();
    }
}
