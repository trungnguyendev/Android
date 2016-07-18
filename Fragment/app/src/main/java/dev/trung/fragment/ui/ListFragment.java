package dev.trung.fragment.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


import java.util.ArrayList;
import java.util.List;

import dev.trung.fragment.R;
import dev.trung.fragment.databinding.FragmentListBinding;
import dev.trung.fragment.listener.ListFragmentListener;


/**
 * Created by trungnv on 7/16/2016.
 */

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListFragmentListener mListFragmentListener;
    private FragmentListBinding mBinding;
    private ArrayAdapter<String> mAdapter;
    private List<String> mList;

    public ListFragment(ListFragmentListener mListFragmentListener) {
        this.mListFragmentListener = mListFragmentListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        mBinding = DataBindingUtil.bind(v);
        mList = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            mList.add("Trung Developer " + i);
        }
        mAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, mList);
        mBinding.listProduct.setAdapter(mAdapter);
        mBinding.listProduct.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mListFragmentListener.onItemClickListen(mList.get(i));
    }
}
