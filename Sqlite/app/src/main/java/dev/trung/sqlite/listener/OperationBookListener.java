package dev.trung.sqlite.listener;

/**
 * Created by trungnv on 7/26/2016.
 */

public interface OperationBookListener {
    void updateBookSelect(int rowId);

    void deleteBookSelect(int rowId, int position);
}
