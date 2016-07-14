package dev.trung.recyclerview.ui.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by trungnv on 7/14/2016.
 */
//ViewDataBinding

public abstract class BaseAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {

    private int mModelLayout;
    private List<T> mListModel;

    public BaseAdapter() {
    }

    public BaseAdapter(List<T> mListModel, int mModelLayout) {
        this.mListModel = mListModel;
        this.mModelLayout = mModelLayout;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        T model = getItem(position);
        populateViewHolder(holder, model, position);
    }

    @Override
    public int getItemCount() {
        return mListModel.size();
    }

    public T getItem(int p) {
        return mListModel.get(p);
    }

    @Override
    public int getItemViewType(int position) {
        return mModelLayout;
    }

    abstract protected void populateViewHolder(VH viewHolder, T model, int position);
}
