package dev.trung.readwritefile;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.trung.readwritefile.databinding.ActivityMainBinding;
import dev.trung.readwritefile.databinding.FilesItemLayoutBinding;
import dev.trung.readwritefile.model.File;
import dev.trung.readwritefile.ui.AddFileDialog;
import dev.trung.readwritefile.ui.EditDialog;
import dev.trung.readwritefile.ui.FileAdapter;
import dev.trung.readwritefile.util.LogUtil;
import dev.trung.readwritefile.util.Util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AddFileDialog.OnSelectAction, FileAdapter.OnClickItemListener, EditDialog.OnSelectActionEdit {
    private ActivityMainBinding mBinding;
    private FileAdapter mFileAdapter;
    private List<File> mLiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mLiles = new ArrayList<File>();
        mLiles = Util.getAllFile(this);
        mBinding.btnAddFile.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mLiles != null) {
            mFileAdapter = new FileAdapter(mLiles, this);
            mBinding.recyclerFiles.setHasFixedSize(true);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);
            mBinding.recyclerFiles.setLayoutManager(manager);
            mBinding.recyclerFiles.setAdapter(mFileAdapter);
        }
    }

    @Override
    public void onClick(View view) {
        AddFileDialog dialog = new AddFileDialog(this);
        dialog.show(getSupportFragmentManager(), "ADD_FILE");
    }

    @Override
    public void onClickOk(String ms) {
        if (ms.length() > 0) {
            File f = Util.createFile(this, ms + ".txt");
            if (f != null) {
                mLiles.add(f);
                mFileAdapter.notifyDataSetChanged();
            } else {
                Toast.makeText(this, "Name file exists", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Name file is not null", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClickCancle() {
        Toast.makeText(this, "Cancle!", Toast.LENGTH_SHORT);
    }

    @Override
    public void onClickItem(File file) {
        Toast.makeText(this, "Content:\n" + Util.readFile(this, file.getNameFile()), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClickEditItem(File file) {
        EditDialog dialog = new EditDialog(this, this, file);
        dialog.show(getSupportFragmentManager(), "ADD_FILE");
    }

    @Override
    public void onClickOKk(String ms, File file) {
        boolean isWrite = Util.writeFile(this, file.getNameFile(), ms);
        if (isWrite) {
            Toast.makeText(this, "Done!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Can't write!Try again", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClickCanclee() {
        Toast.makeText(this, "Cancle!", Toast.LENGTH_SHORT);
    }
}
