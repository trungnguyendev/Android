package dev.trung.fragment.service;

import android.app.Fragment;
import android.app.FragmentTransaction;

/**
 * Created by trungnv on 7/16/2016.
 */
public class FragmentManagerImpl implements FragmentManager {
    private android.support.v4.app.FragmentManager mFragmentManager;
    private android.support.v4.app.FragmentTransaction mFragmentTransaction;

    public FragmentManagerImpl(android.support.v4.app.FragmentManager mFragmentManager) {
        this.mFragmentManager = mFragmentManager;
    }

    @Override
    public void addFragment(int idF, android.support.v4.app.Fragment fragment, String tagF) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(idF, fragment, tagF);
        mFragmentTransaction.commit();
    }

    @Override
    public void replaceFragment(int idF, android.support.v4.app.Fragment fragment, String tagF) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(idF, fragment, tagF);
        mFragmentTransaction.commit();
    }

    @Override
    public void removeFragment(android.support.v4.app.Fragment fragment) {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.remove(fragment);
        mFragmentTransaction.commit();
    }
}
