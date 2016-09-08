package dev.trung.music.data.local;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import dev.trung.music.data.model.Song;
import dev.trung.music.util.LogUtil;

/**
 * Created by trungnv on 9/7/2016.
 */
public class MusicRetriever {
    private ContentResolver mContentResolver;
    private List<Song> mSongs;

    public MusicRetriever(ContentResolver mContentResolver) {
        this.mContentResolver = mContentResolver;
        mSongs = new ArrayList<Song>();
        LogUtil.TAG = MusicRetriever.this.getClass().getName();
    }

    public void findFromExternalStorage() {
        Uri u = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        LogUtil.i("Querying media...");
        LogUtil.i("Uri : " + u.toString());

        Cursor c = mContentResolver.query(u,
                null,
                MediaStore.Audio.Media.IS_MUSIC + "=1",
                null,
                MediaStore.Audio.Media.TITLE);
        LogUtil.i("Query finished . " + (c == null ? "Return Null" : "Return a cursor"));

        if (c == null) {
            LogUtil.e("Failed to retriever music : cursor is null");
            return;
        }
        if (!c.moveToFirst()) {
            LogUtil.e("Failed to move cursor to first row (no query results).");
            return;
        }

        LogUtil.i("Listing...");
        int idColumn = c.getColumnIndex(MediaStore.Audio.Media._ID);
        int artistColumn = c.getColumnIndex(MediaStore.Audio.Media.ARTIST);
        int titleColumn = c.getColumnIndex(MediaStore.Audio.Media.TITLE);
        int albumColumn = c.getColumnIndex(MediaStore.Audio.Media.ALBUM);
        int durationColumn = c.getColumnIndex(MediaStore.Audio.Media.DURATION);

        LogUtil.i("Title column index: " + String.valueOf(titleColumn));
        LogUtil.i("ID column index: " + String.valueOf(idColumn));

        do {
            mSongs.add(new Song(c.getLong(idColumn),
                    c.getString(artistColumn),
                    c.getString(titleColumn),
                    c.getString(albumColumn),
                    c.getLong(durationColumn)));
        } while (c.moveToNext());
        LogUtil.i("Query data is done , music is ready");
        LogUtil.i("Number of song is : " + mSongs.size());
    }

    public ContentResolver getContentResolver() {
        return mContentResolver;
    }

    public List<Song> getAll() {
        return mSongs;
    }

    public List<String> getAll(String field) {
        List<String> l = new ArrayList<String>();
        for (Song s : mSongs) {
            switch (field) {
                case Song.ID:
                    l.add(String.valueOf(s.getId()));
                    break;
                case Song.ARTIST:
                    l.add(s.getArtist());
                    break;
                case Song.TITLE:
                    l.add(s.getTitle());
                    break;
                case Song.ALBUM:
                    l.add(s.getAlbum());
                    break;
                case Song.DURATION:
                    l.add(String.valueOf(s.getDuration()));
                    break;
                default:
            }
        }
        LogUtil.i("Method getAllBy field : " + l.size());
        return l;
    }

    public int getNumberOfSong() {
        return mSongs != null ? mSongs.size() : 0;
    }
}

