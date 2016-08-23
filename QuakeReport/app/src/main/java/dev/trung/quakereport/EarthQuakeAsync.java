package dev.trung.quakereport;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;

import dev.trung.quakereport.listener.ResponseJsonListener;
import dev.trung.quakereport.model.EarthQuake;
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
        String jsonResponse = null;
        try {
            jsonResponse = Utils.makeHttpRequestGET(urls[0]);
        } catch (Exception e) {

        }
        return jsonResponse;
    }

    @Override
    protected void onPostExecute(String result) {
        if (result != null) {
            mResponseJsonListener.responseJson(result);
        }
    }
}
