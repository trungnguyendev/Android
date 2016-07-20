package dev.trung.sqlite.ui.adapter;

import android.support.v7.widget.RecyclerView;

import java.util.List;

/**
 * Created by trungnv on 7/20/2016.
 */

public abstract class Adapter<T, VH extends ViewHolder> extends RecyclerView.Adapter<VH> {
    private int mModelLayout;
    private List<T> mList;

    public Adapter() {
    }

    public Adapter(int mModelLayout, List<T> mList) {
        this.mModelLayout = mModelLayout;
        this.mList = mList;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        T model = getItem(position);
        populateViewHolder(holder, model, position);
    }

    @Override
    public int getItemCount() {
        return mList != null ? mList.size() : 0;
    }

    public T getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return mModelLayout;
    }

    abstract protected void populateViewHolder(VH viewHolder, T model, int position);
}
