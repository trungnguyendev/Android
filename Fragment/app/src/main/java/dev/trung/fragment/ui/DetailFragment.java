package dev.trung.fragment.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import dev.trung.fragment.R;
import dev.trung.fragment.databinding.FragmentDetailBinding;

/**
 * Created by trungnv on 7/16/2016.
 */

public class DetailFragment extends Fragment {
    private String mValue;
    private FragmentDetailBinding mBinding;

    public DetailFragment(String mValue) {
        this.mValue = mValue;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail, container, false);
        mBinding = DataBindingUtil.bind(v);
        mBinding.textMessage.setText(mValue);
        return v;
    }
}
