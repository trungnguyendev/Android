package dev.trung.readwritefile.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

import dev.trung.readwritefile.model.File;
import dev.trung.readwritefile.util.Util;

/**
 * Created by trungnv on 7/30/2016.
 */

public class EditDialog extends DialogFragment {
    public interface OnSelectActionEdit {
        void onClickOKk(String ms, File file);

        void onClickCanclee();
    }

    private EditDialog.OnSelectActionEdit mOnSelectAction;
    private File mFile;
    private Context mContext;

    public EditDialog(Context context, EditDialog.OnSelectActionEdit mOnSelectAction, File file) {
        this.mFile = file;
        this.mOnSelectAction = mOnSelectAction;
        this.mContext = context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final EditText editText = new EditText(getContext());
        editText.setPadding(0, 16, 0, 16);
        editText.setText(Util.readFile(mContext, mFile.getNameFile()));
        return new android.app.AlertDialog.Builder(getActivity())
                .setTitle("Write content!")
                .setView(editText)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mOnSelectAction.onClickOKk(editText.getText().toString().trim(), mFile);
                    }
                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mOnSelectAction.onClickCanclee();
                    }
                })
                .create();
    }
}
