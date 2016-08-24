package dev.trung.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.net.URL;
import java.util.List;

import dev.trung.quakereport.model.EarthQuake;
import dev.trung.quakereport.util.QueryUtil;
import dev.trung.quakereport.util.Utils;

/**
 * Created by trungnv on 8/24/2016.
 */

public class EarthQuakeLoader extends AsyncTaskLoader<List<EarthQuake>> {
    private URL mUrl;

    public EarthQuakeLoader(Context context, URL mUrl) {
        super(context);
        this.mUrl = mUrl;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<EarthQuake> loadInBackground() {
        return QueryUtil.extractFeatureFromJson(QueryUtil.makeHttpRequestGET(mUrl));
    }
}
