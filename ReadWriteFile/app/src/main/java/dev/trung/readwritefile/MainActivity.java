package dev.trung.readwritefile;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import dev.trung.readwritefile.databinding.ActivityMainBinding;
import dev.trung.readwritefile.databinding.FilesItemLayoutBinding;
import dev.trung.readwritefile.model.File;
import dev.trung.readwritefile.ui.AddFileDialog;
import dev.trung.readwritefile.ui.FileAdapter;
import dev.trung.readwritefile.util.Util;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AddFileDialog.OnSelectAction, FileAdapter.OnClickItemListener {
    private ActivityMainBinding mBinding;
    private FileAdapter mFileAdapter;
    private List<File> mLiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mLiles = new ArrayList<File>();
        mBinding.fab.setOnClickListener(this);
        String path = Util.createFile(this, "abcabcabcabc");
        File file = new File("abcabcabcabc", path);
        mLiles.add(file);
        mLiles.add(file);

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
        if (ms.isEmpty()) {
            String path = Util.createFile(this, ms);
            File file = new File(ms, path);
            if (file != null) {
                mLiles.add(file);
                mFileAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onClickCancle() {
        Toast.makeText(this, "Cancle!", Toast.LENGTH_SHORT);
    }

    @Override
    public void onClickItem(File file) {

    }
}
