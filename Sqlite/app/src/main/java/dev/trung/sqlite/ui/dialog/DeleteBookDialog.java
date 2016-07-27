package dev.trung.sqlite.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

import dev.trung.sqlite.listener.DeleteBookDialogListener;

/**
 * Created by trungnv on 7/21/2016.
 */

public class DeleteBookDialog extends DialogFragment {
    private Context mContext;
    private DeleteBookDialogListener mBookDialogListener;
    private int rowId;
    private int mPosition;

    public DeleteBookDialog(Context mContext, DeleteBookDialogListener listener, int rowId, int mPosition) {
        this.mContext = mContext;
        this.rowId = rowId;
        this.mPosition = mPosition;
        mBookDialogListener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(mContext)
                .setTitle("Thông báo!")
                .setMessage("Bạn có chắc muốn xóa không?")
                .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mBookDialogListener.onOKClick(rowId, mPosition);
                    }
                })
                .setNegativeButton("Bỏ qua", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mBookDialogListener.onCancleClick();
                    }
                })
                .create();
    }
}
