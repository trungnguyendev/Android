package dev.trung.fragment;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import dev.trung.fragment.databinding.ActivityMainBinding;
import dev.trung.fragment.listener.ListFragmentListener;

import dev.trung.fragment.ui.DetailFragment;
import dev.trung.fragment.ui.ListFragment;


public class MainActivity extends AppCompatActivity implements ListFragmentListener {
    private ActivityMainBinding mBinding;
    private ListFragment mListFragment;
    private DetailFragment mDetailFragment;
    private FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        if (savedInstanceState != null) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (fragment != null)
                getSupportFragmentManager().beginTransaction().remove(fragment).commit();
        }
        mListFragment = new ListFragment(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, mListFragment).commit();
    }

    @Override
    public void onItemClickListen(Object value) {
        String s = String.valueOf(value);
        mDetailFragment = new DetailFragment(s);
        mFragmentTransaction = getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.fragment_container, mDetailFragment);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

}
