package dev.trung.music;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import dev.trung.music.data.local.MusicRetriever;
import dev.trung.music.data.local.PrepareMusicRetrieverTask;
import dev.trung.music.data.model.Song;
import dev.trung.music.databinding.ActivityMainBinding;
import dev.trung.music.ui.adapter.MusicAdapter;
import dev.trung.music.util.LogUtil;

public class MainActivity extends AppCompatActivity implements PrepareMusicRetrieverTask.PrepareMusicRetrieverTaskListener, AdapterView.OnItemClickListener {
    private MusicRetriever mr;
    private ActivityMainBinding mBinding;
    private MusicAdapter mMusicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mr = new MusicRetriever(getContentResolver());
        PrepareMusicRetrieverTask task = new PrepareMusicRetrieverTask(mr, this);
        task.execute();
    }

    @Override
    public void onPrepareMusicRetrieverTask() {
        mMusicAdapter = new MusicAdapter(this, mr.getAll());
        mBinding.lvSong.setAdapter(mMusicAdapter);
        mBinding.lvSong.setOnItemClickListener(this);
        Toast.makeText(this, "Number of song in SD card " + mr.getNumberOfSong(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, "Uri : " + mMusicAdapter.getItem(i).getUri(), Toast.LENGTH_SHORT).show();
        LogUtil.i(mMusicAdapter.getItem(i).toString());
    }
}