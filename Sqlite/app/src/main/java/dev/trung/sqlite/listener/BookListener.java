package dev.trung.sqlite.listener;

/**
 * Created by trungnv on 7/26/2016.
 */

public interface BookListener {
    void updateBook(int rowId);

    void deleteBook(int rowId, int position);
}
