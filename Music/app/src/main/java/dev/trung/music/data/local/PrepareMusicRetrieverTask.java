package dev.trung.music.data.local;

import android.os.AsyncTask;

import dev.trung.music.util.LogUtil;

/**
 * Created by trungnv on 9/8/2016.
 */
public class PrepareMusicRetrieverTask extends AsyncTask<Void, Void, Void> {
    private MusicRetriever mMusicRetriever;
    private PrepareMusicRetrieverTaskListener mListener;

    public PrepareMusicRetrieverTask(MusicRetriever mMusicRetriever, PrepareMusicRetrieverTaskListener mListener) {
        this.mMusicRetriever = mMusicRetriever;
        this.mListener = mListener;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        mMusicRetriever.findFromExternalStorage();
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        mListener.onPrepareMusicRetrieverTask();
    }

    public interface PrepareMusicRetrieverTaskListener {
        void onPrepareMusicRetrieverTask();
    }
}
