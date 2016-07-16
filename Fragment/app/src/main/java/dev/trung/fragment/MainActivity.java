package dev.trung.fragment;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import dev.trung.fragment.databinding.ActivityMainBinding;
import dev.trung.fragment.listener.ListFragmentListener;
import dev.trung.fragment.service.FragmentManagerImpl;
import dev.trung.fragment.ui.DetailFragment;
import dev.trung.fragment.ui.ListFragment;
import dev.trung.fragment.util.ConstantUtil;

public class MainActivity extends AppCompatActivity implements ListFragmentListener {
    private ActivityMainBinding mBinding;
    private dev.trung.fragment.service.FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        mFragmentManager = new FragmentManagerImpl(getSupportFragmentManager());
        ListFragment listFragment = new ListFragment(this);
        mFragmentManager.addFragment(R.id.fragment_list, listFragment, ConstantUtil.FRAGMENT_LIST);
    }

    @Override
    public void onItemClickListen(String value) {
        DetailFragment detailFragment = new DetailFragment(value);
        mBinding.fragmentList.setVisibility(View.GONE);
        mBinding.fragmentDetail.setVisibility(View.VISIBLE);
        mFragmentManager.addFragment(R.id.fragment_detail, detailFragment, ConstantUtil.FRAGMENT_DETAIL);
    }
}
