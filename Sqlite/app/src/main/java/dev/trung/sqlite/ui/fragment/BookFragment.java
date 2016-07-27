package dev.trung.sqlite.ui.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import dev.trung.sqlite.R;
import dev.trung.sqlite.dao.DbHelper;
import dev.trung.sqlite.databinding.FragmentBookBinding;
import dev.trung.sqlite.listener.BookListener;
import dev.trung.sqlite.listener.DeleteBookDialogListener;
import dev.trung.sqlite.listener.OperationBookListener;
import dev.trung.sqlite.model.Book;
import dev.trung.sqlite.ui.adapter.BookAdapter;
import dev.trung.sqlite.ui.dialog.DeleteBookDialog;
import dev.trung.sqlite.util.Constant;
import dev.trung.sqlite.util.LogUtil;

/**
 * Created by trungnv on 7/20/2016.
 */

public class BookFragment extends Fragment implements OperationBookListener {
    private DeleteBookDialog mDeleteBookDialog;
    private FragmentManager mFragmentManager;
    private FragmentBookBinding mBinding;
    private BookAdapter mBookAdapter;
    private List<Book> mBookList;
    private DbHelper mDbHelper;
    private BookListener mBookListener;

    public BookFragment(BookListener mBookListener) {
        this.mBookListener = mBookListener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        mBinding = DataBindingUtil.bind(view);
        mFragmentManager = getFragmentManager();
        mDbHelper = new DbHelper(getContext());
        mBookList = new ArrayList<Book>();
        mBookList = mDbHelper.getAll();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mBookList != null) {
            mBookAdapter = new BookAdapter(mBookList, R.layout.card_book_item, getContext(), mFragmentManager, this);
            mBinding.recyclerBook.setHasFixedSize(true);
            RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 2);
            mBinding.recyclerBook.setLayoutManager(manager);
            mBinding.recyclerBook.setAdapter(mBookAdapter);
        }
    }

    @Override
    public void updateBookSelect(int rowId) {
        mBookListener.updateBook(rowId);
    }

    @Override
    public void deleteBookSelect(int rowId, int position) {
        mBookListener.deleteBook(rowId, position);
    }

    public void notifyChange() {
        mBookList = mDbHelper.getAll();
        mBookAdapter.notifyDataSetChanged();
    }

    public void remove(int p) {
        mBookAdapter.removeItem(p);
    }
}
