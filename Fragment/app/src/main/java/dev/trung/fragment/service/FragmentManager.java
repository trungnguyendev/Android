package dev.trung.fragment.service;

import android.app.Fragment;

/**
 * Created by trungnv on 7/16/2016.
 */

public interface FragmentManager {
    void addFragment(int idF, android.support.v4.app.Fragment fragment, String tagF);

    void replaceFragment(int idF, android.support.v4.app.Fragment fragment, String tagF);

    void removeFragment(android.support.v4.app.Fragment fragment);
}
