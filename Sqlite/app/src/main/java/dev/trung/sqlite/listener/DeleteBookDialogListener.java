package dev.trung.sqlite.listener;

/**
 * Created by trungnv on 7/21/2016.
 */

public interface DeleteBookDialogListener {
    void onOKClick(int rowId, int position);

    void onCancleClick();
}
