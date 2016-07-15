package dev.trung.dialog.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by trungnv on 7/15/2016.
 */

public class ProgressDialog extends DialogFragment {
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        android.app.ProgressDialog progressDialog = new android.app.ProgressDialog(getActivity());
        progressDialog.setMessage("waiting..");
        return progressDialog;
    }
}
