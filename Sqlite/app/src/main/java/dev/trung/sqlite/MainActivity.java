package dev.trung.sqlite;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import dev.trung.sqlite.dao.DbHelper;
import dev.trung.sqlite.databinding.ActivityMainBinding;
import dev.trung.sqlite.model.Book;
import dev.trung.sqlite.ui.BookFragment;
import dev.trung.sqlite.util.LogUtil;
import dev.trung.sqlite.util.ToastUtil;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        if (savedInstanceState != null) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (fragment != null)
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        BookFragment bookFragment = new BookFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, bookFragment).commit();
    }
}
