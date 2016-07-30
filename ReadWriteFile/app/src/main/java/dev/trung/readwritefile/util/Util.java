package dev.trung.readwritefile.util;

import android.content.Context;
import android.net.Uri;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trungnv on 7/29/2016.
 */

public class Util {

    public static dev.trung.readwritefile.model.File createFile(Context context, String nameFile) {
        dev.trung.readwritefile.model.File f = null;
        File file = new File(context.getFilesDir(), nameFile);
        if (!file.exists()) {
            try {
                file.createNewFile();
                f = new dev.trung.readwritefile.model.File();
                f.setNameFile(nameFile);
                f.setUri(file.getPath());
                LogUtil.d(file.getPath());
                return f;
            } catch (IOException e) {
                LogUtil.d(e.getMessage());
            }
        }
        return f;
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

    public static List<dev.trung.readwritefile.model.File> getAllFile(Context context) {
        List<dev.trung.readwritefile.model.File> fileList = new ArrayList<dev.trung.readwritefile.model.File>();
        File file = new File(context.getFilesDir().getPath());
        File[] l = file.listFiles();
        for (File f : l) {
            if (f.isDirectory()) {

            } else {
                if (f.getName().endsWith(".txt")) {
                    dev.trung.readwritefile.model.File file1 = new dev.trung.readwritefile.model.File(f.getName(), f.getPath());
                    fileList.add(file1);
                }
            }
        }
        return fileList;
    }
}
