package dev.trung.music.data.model;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by trungnv on 9/7/2016.
 */
public class Song {
    public final static String ID = "ID";
    public final static String ARTIST = "ARTIST";
    public final static String TITLE = "TITLE";
    public final static String ALBUM = "ALBUM";
    public final static String DURATION = "DURATION";
    private long id;
    private String artist;
    private String title;
    private String album;
    private long duration;

    public Song(long id, String artist, String title, String album, long duration) {
        this.id = id;
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public long getDuration() {
        return duration;
    }

    public Uri getUri() {
        return ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        return s.append("***************Song*************\n")
                .append("Id :").append(id + "\n")
                .append("Artist :").append(artist + "\n")
                .append("Title :").append(title + "\n")
                .append("Album :").append(album + "\n")
                .append("Duration :").append(duration + "\n")
                .toString();
    }
}
