package dev.trung.sqlite.model;

import android.provider.BaseColumns;

import dev.trung.sqlite.dao.Entry;

/**
 * Created by trungnv on 7/20/2016.
 */

public class Book {
    private int id;
    private String title;
    private int image;
    private String content;
    private String author;

    public Book() {
    }

    public Book(String title, int image, String content, String author) {
        this.title = title;
        this.image = image;
        this.content = content;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
