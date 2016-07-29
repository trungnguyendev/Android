package dev.trung.readwritefile.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;


/**
 * Created by trungnv on 7/29/2016.
 */

public class AddFileDialog extends DialogFragment {

    public interface OnSelectAction {
        void onClickOk(String ms);

        void onClickCancle();
    }

    private OnSelectAction mOnSelectAction;

    public AddFileDialog(OnSelectAction mOnSelectAction) {
        this.mOnSelectAction = mOnSelectAction;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final EditText editText = new EditText(getContext());
        editText.setPadding(0, 16, 0, 16);
        return new android.app.AlertDialog.Builder(getActivity())
                .setTitle("File name!")
                .setView(editText)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mOnSelectAction.onClickOk(editText.getText().toString().trim());
                    }
                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mOnSelectAction.onClickCancle();
                    }
                })
                .create();
    }
}
