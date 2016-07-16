package dev.trung.fragment.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import dev.trung.fragment.R;
import dev.trung.fragment.listener.ListFragmentListener;

/**
 * Created by trungnv on 7/16/2016.
 */

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListFragmentListener mListFragmentListener;

    public ListFragment(ListFragmentListener mListFragmentListener) {
        this.mListFragmentListener = mListFragmentListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        ListView listView = (ListView) v.findViewById(R.id.list_product);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.products));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        mListFragmentListener.onItemClickListen(String.valueOf(i) + " IsClick");
    }
}
