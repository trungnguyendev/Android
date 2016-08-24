package dev.trung.quakereport;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

import dev.trung.quakereport.listener.ResponseJsonListener;
import dev.trung.quakereport.model.EarthQuake;
import dev.trung.quakereport.util.LogUtil;
import dev.trung.quakereport.util.QueryUtil;
import dev.trung.quakereport.util.Utils;

/**
 * Created by trungnv on 8/23/2016.
 */

public class EarthQuakeAsync extends AsyncTask<URL, Void, String> {
    private ResponseJsonListener mResponseJsonListener;

    public EarthQuakeAsync(ResponseJsonListener mResponseJsonListener) {
        this.mResponseJsonListener = mResponseJsonListener;
    }


    @Override
    protected String doInBackground(URL... urls) {
        if (urls.length < 1 || urls[0] == null) {
            return null;
        }
        String jsonResponse = null;
        try {
            jsonResponse = QueryUtil.makeHttpRequestGET(urls[0]);
        } catch (Exception e) {
            LogUtil.e(e.getMessage());
        }
        return jsonResponse;
    }

    @Override
    protected void onPostExecute(String result) {
        if (result == null) {
            return;
        }
        mResponseJsonListener.responseJson(result);
    }
}
