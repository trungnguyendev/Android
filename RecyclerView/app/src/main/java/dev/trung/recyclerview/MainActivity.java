package dev.trung.recyclerview;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.trung.recyclerview.databinding.ActivityMainBinding;

import dev.trung.recyclerview.models.User;
import dev.trung.recyclerview.ui.adapter.UserAdapter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private List<User> mUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        mUsers = new ArrayList<User>();
        for (int i = 0; i < 1000; i++) {
            mUsers.add(new User("Trung", "Android Developer"));
        }

        UserAdapter adapter = new UserAdapter(mUsers, R.layout.rycycler_user_item);
        mBinding.recyclerUser.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);
        mBinding.recyclerUser.setLayoutManager(manager);
        mBinding.recyclerUser.setAdapter(adapter);
    }
}
