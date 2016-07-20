package dev.trung.sqlite.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import dev.trung.sqlite.databinding.CardBookItemBinding;
import dev.trung.sqlite.model.Book;
import dev.trung.sqlite.util.ToastUtil;

/**
 * Created by trungnv on 7/20/2016.
 */

public class BookAdapter extends Adapter<Book, BookAdapter.ViewHolder> {
    private Context mContext;

    public BookAdapter(List<Book> books, int mLayout, Context mContext) {
        super(mLayout, books);
        this.mContext = mContext;
    }

    @Override
    protected void populateViewHolder(ViewHolder viewHolder, Book model, final int position) {
        viewHolder.getmBinding().textTitle.setText(model.getTitle());
        viewHolder.getmBinding().textAuthor.setText(model.getAuthor());
        Glide.with(mContext).load(model.getImage()).into(viewHolder.getmBinding().imageThumbnail);
        viewHolder.getmBinding().overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ToastUtil.Toast(mContext, "Click!" + position);
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends dev.trung.sqlite.ui.adapter.ViewHolder<CardBookItemBinding> {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
