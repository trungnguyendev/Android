package dev.trung.sqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import dev.trung.sqlite.model.Book;

/**
 * Created by trungnv on 7/20/2016.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "book.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Entry.Book.SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(Entry.Book.SQL_DELETE_TABLE);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public long insert(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Entry.Book.COLUMN_TITLE, book.getTitle());
        values.put(Entry.Book.COLUMN_IMAGE, book.getImage());
        values.put(Entry.Book.COLUMN_CONTENT, book.getContent());
        values.put(Entry.Book.COLUMN_AUTHOR, book.getAuthor());
        long newRowId;
        newRowId = db.insert(
                Entry.Book.TABLE_NAME,
                null,
                values);
        return newRowId;
    }

    public List<Book> getAll() {
        List<Book> books = new ArrayList<Book>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.query(
                Entry.Book.TABLE_NAME,
                Entry.Book.COLUMNS_RETURN,
                null, null, null, null, null
        );
        if (c.moveToFirst()) {
            do {
                Book book = new Book();
                book.setId(c.getInt(c.getColumnIndex(Entry.Book.COLUMN_ID)));
                book.setTitle(c.getString(c.getColumnIndex(Entry.Book.COLUMN_TITLE)));
                book.setImage(c.getInt(c.getColumnIndex(Entry.Book.COLUMN_IMAGE)));
                book.setContent(c.getString(c.getColumnIndex(Entry.Book.COLUMN_CONTENT)));
                book.setAuthor(c.getString(c.getColumnIndex(Entry.Book.COLUMN_AUTHOR)));
                books.add(book);
            } while (c.moveToNext());
        }
        return books;
    }

    public int delete(int rowId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = Entry.Book.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(rowId)};
        int i = db.delete(Entry.Book.TABLE_NAME,
                selection,
                selectionArgs);
        return i;
    }

    public int update(Book book) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Entry.Book.COLUMN_TITLE, book.getTitle());
        values.put(Entry.Book.COLUMN_IMAGE, book.getImage());
        values.put(Entry.Book.COLUMN_CONTENT, book.getContent());
        values.put(Entry.Book.COLUMN_AUTHOR, book.getAuthor());
        String selection = Entry.Book.COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(book.getId())};
        int i = db.update(Entry.Book.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return i;
    }

    public Book getById(int rowId) {
        Book book = new Book();
//        SQLiteDatabase db = this.getReadableDatabase();
        String selection = Entry.Book.COLUMN_ID + " +?";
        String[] selectionArgs = {String.valueOf(rowId)};
//        Cursor c = db.query(
//                Entry.Book.TABLE_NAME,
//                Entry.Book.COLUMNS_RETURN,
//                selection, selectionArgs, null, null, null
//        );
        Cursor c = this.getReadableDatabase()
                .rawQuery("select * from books where id = ?", new String[]{String.valueOf(rowId)});
        if (c.moveToFirst()) {
            book.setId(c.getInt(c.getColumnIndex(Entry.Book.COLUMN_ID)));
            book.setTitle(c.getString(c.getColumnIndex(Entry.Book.COLUMN_TITLE)));
            book.setImage(c.getInt(c.getColumnIndex(Entry.Book.COLUMN_IMAGE)));
            book.setContent(c.getString(c.getColumnIndex(Entry.Book.COLUMN_CONTENT)));
            book.setAuthor(c.getString(c.getColumnIndex(Entry.Book.COLUMN_AUTHOR)));
        }
        return book;
    }
}
