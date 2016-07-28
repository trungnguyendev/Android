package dev.trung.contentprovider.ui;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by trungnv on 7/28/2016.
 */

public abstract class Adapter<T, VH extends ViewHolder> extends RecyclerView.Adapter<VH> {
    private List<T> mList;

    public Adapter(List<T> mList) {
        this.mList = mList;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        T model = getItem(position);
        populateViewHolder(holder, model, position);
    }

    @Override
    public int getItemCount() {
        return mList.size() >= 0 ? mList.size() : 0;
    }

    public T getItem(int position) {
        return mList.get(position) != null ? mList.get(position) : null;
    }

    abstract protected void populateViewHolder(VH viewHolder, T model, int position);
}
