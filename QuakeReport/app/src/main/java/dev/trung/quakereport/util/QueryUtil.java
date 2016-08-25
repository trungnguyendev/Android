package dev.trung.quakereport.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dev.trung.quakereport.model.EarthQuake;

/**
 * Created by trungnv on 8/24/2016.
 */

public class QueryUtil {
    public static String makeHttpRequestGET(URL url) {
        String jsonResponse = "";
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            jsonResponse = readFromStream(inputStream);
        } catch (IOException e) {
            LogUtil.e(e.getMessage());
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LogUtil.e(e.getMessage());
                    return null;
                }
            }
        }
        return jsonResponse;
    }

    public static List<EarthQuake> extractFeatureFromJson(String result) {
        List<EarthQuake> earthQuakes = new ArrayList<EarthQuake>();
        try {
            JSONObject object = new JSONObject(result);
            JSONArray array = object.getJSONArray("features");
            for (int i = 0; i < array.length(); i++) {
                JSONObject item = array.getJSONObject(i);
                JSONObject properties = item.getJSONObject("properties");

                String magnitude = Utils.formatMagnitude(Double.parseDouble(properties.getString("mag")));
                String locationPrimary = "";
                String locationOffset = properties.getString("place");
                Date dt = new Date(properties.getLong("time"));
                String date = Utils.formatDate(dt);
                String time = Utils.formatTime(dt);

                EarthQuake model = new EarthQuake(magnitude, locationOffset, locationPrimary, date, time);

                earthQuakes.add(model);
            }
        } catch (JSONException e) {
            LogUtil.e(e.getMessage());
            return null;
        }
        return earthQuakes;
    }

    private static String readFromStream(InputStream inputStream) {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            try {
                String line = bufferedReader.readLine();
                while (line != null) {
                    output.append(line);
                    line = bufferedReader.readLine();
                }
            } catch (IOException e) {
                LogUtil.e(e.getMessage());
                return null;
            }
        }
        return output.toString();
    }
}
