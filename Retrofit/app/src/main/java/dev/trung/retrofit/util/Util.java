package dev.trung.retrofit.util;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by trungnv on 8/3/2016.
 */

public class Util {
    public static String AssetJSONFile(Context context, String fileName) {
        InputStream inputStream = null;
        String result = null;
        try {
            inputStream = context.getAssets().open(fileName);
            byte[] formArray = new byte[inputStream.available()];
            inputStream.read(formArray);
            result = new String(formArray, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }
}
