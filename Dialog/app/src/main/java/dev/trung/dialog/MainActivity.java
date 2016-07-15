package dev.trung.dialog;

import android.databinding.DataBindingUtil;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import dev.trung.dialog.databinding.ActivityMainBinding;
import dev.trung.dialog.ui.DatePickerDialog;
import dev.trung.dialog.ui.ProgressDialog;
import dev.trung.dialog.ui.TimePickerDialog;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        mBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.dialogs));
        mBinding.listDialog.setAdapter(adapter);
        mBinding.listDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        dev.trung.dialog.ui.AlertDialog dialog = new dev.trung.dialog.ui.AlertDialog();
                        dialog.show(mFragmentManager, "Alert");
                        break;
                    case 1:
                        ProgressDialog progressDialog = new ProgressDialog();
                        progressDialog.show(mFragmentManager, "Progress");
                        break;
                    case 2:
                        DatePickerDialog datePickerDialog = new DatePickerDialog();
                        datePickerDialog.show(mFragmentManager, "Picker");
                        break;
                    case 3:
                        TimePickerDialog timePickerDialog = new TimePickerDialog();
                        timePickerDialog.show(mFragmentManager, "TimePicker");
                        break;
                }
            }
        });
    }
}
