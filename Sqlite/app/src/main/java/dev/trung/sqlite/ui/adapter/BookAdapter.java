package dev.trung.sqlite.ui.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import dev.trung.sqlite.R;
import dev.trung.sqlite.dao.DbHelper;
import dev.trung.sqlite.databinding.CardBookItemBinding;
import dev.trung.sqlite.listener.OperationBookListener;
import dev.trung.sqlite.model.Book;
import dev.trung.sqlite.util.ToastUtil;

/**
 * Created by trungnv on 7/20/2016.
 */

public class BookAdapter extends Adapter<Book, BookAdapter.ViewHolder> {
    private Context mContext;
    private PopupMenu mPopupMenu;
    private FragmentManager mFragmentManager;
    private DbHelper mDbHelper;
    private OperationBookListener mOperationBookListener;

    public BookAdapter(List<Book> books, int mLayout, Context mContext, FragmentManager mFragmentManager, OperationBookListener mOperationBookListener) {
        super(mLayout, books);
        this.mContext = mContext;
        this.mFragmentManager = mFragmentManager;
        this.mOperationBookListener = mOperationBookListener;
    }

    @Override
    protected void populateViewHolder(final ViewHolder viewHolder, final Book model, final int position) {
        viewHolder.getmBinding().textTitle.setText(model.getTitle());
        viewHolder.getmBinding().textAuthor.setText(model.getAuthor());
        Glide.with(mContext).load(model.getImage()).into(viewHolder.getmBinding().imageThumbnail);
        viewHolder.getmBinding().overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPopupMenu = new PopupMenu(mContext, viewHolder.getmBinding().overflow);
                mPopupMenu.getMenuInflater().inflate(R.menu.menu_popup, mPopupMenu.getMenu());
                mPopupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_update:
                                mOperationBookListener.updateBookSelect(model.getId());
                                break;
                            case R.id.action_delete:
                                mOperationBookListener.deleteBookSelect(model.getId(), position);
                                break;
                            default:
                        }
                        return false;
                    }
                });
                mPopupMenu.show();
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
