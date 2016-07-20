package dev.trung.sqlite.dao;

import android.provider.BaseColumns;

/**
 * Created by trungnv on 7/20/2016.
 */

public class Entry {
    public static class Book implements BaseColumns {
        public final static String TABLE_NAME = "books";
        public final static String COLUMN_ID = "id";
        public final static String COLUMN_TITLE = "title";
        public final static String COLUMN_IMAGE = "image";
        public final static String COLUMN_CONTENT = "content";
        public final static String COLUMN_AUTHOR = "author";
        public final static String SQL_CREATE_TABLE =
                "CREATE TABLE " + TABLE_NAME + "(" +
                        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_TITLE + " TEXT," +
                        COLUMN_IMAGE + " INTEGER," +
                        COLUMN_CONTENT + " TEXT," +
                        COLUMN_AUTHOR + " TEXT" + " )";
        public final static String SQL_DELETE_TABLE =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
        public final static String[] COLUMNS_RETURN = {
                COLUMN_ID,
                COLUMN_TITLE,
                COLUMN_IMAGE,
                COLUMN_CONTENT,
                COLUMN_AUTHOR
        };
    }
}
