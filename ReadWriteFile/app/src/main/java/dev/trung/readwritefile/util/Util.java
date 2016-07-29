package dev.trung.readwritefile.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by trungnv on 7/29/2016.
 */

public class Util {

    public static String createFile(Context context, String nameFile) {
        File file = new File(context.getFilesDir(), nameFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
                LogUtil.d(file.getPath());
                return file.getPath();
            } catch (IOException e) {
                LogUtil.d(e.getMessage());
            }
        }
        return "File tồn tại";
    }

    public static boolean writeFile(Context context, String fileName, String content) {
        FileOutputStream file = null;
        try {
            file = context.openFileOutput(fileName, context.MODE_PRIVATE);
            if (file != null) {
                file.write(content.getBytes());
                file.flush();
                return true;
            } else {
                LogUtil.d("File not found!");
            }
        } catch (FileNotFoundException e) {
            LogUtil.d(e.getMessage());
        } catch (IOException e) {
            LogUtil.d(e.getMessage());
        } finally {
            if (file != null)
                try {
                    file.close();
                } catch (IOException e) {
                    LogUtil.d(e.getMessage());
                }
        }
        return false;
    }

    public static String readFile(Context context, String fileName) {
        StringBuffer stringBuffer;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.openFileInput(fileName)));
            String line;
            stringBuffer = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            LogUtil.d(stringBuffer.toString());
            return stringBuffer.toString();
        } catch (FileNotFoundException e) {
            LogUtil.d(e.getMessage());
        } catch (IOException e) {
            LogUtil.d(e.getMessage());
        }
        return null;
    }
}
