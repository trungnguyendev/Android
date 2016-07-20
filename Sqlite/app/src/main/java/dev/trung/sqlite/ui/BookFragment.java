package dev.trung.sqlite.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dev.trung.sqlite.R;
import dev.trung.sqlite.databinding.FragmentBookBinding;
import dev.trung.sqlite.model.Book;
import dev.trung.sqlite.ui.adapter.BookAdapter;

/**
 * Created by trungnv on 7/20/2016.
 */

public class BookFragment extends Fragment {
    private FragmentBookBinding mBinding;
    private BookAdapter mBookAdapter;
    private List<Book> mBookList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        int[] images = {
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};
        Random random = new Random();
        mBinding = DataBindingUtil.bind(view);
        mBookList = new ArrayList<Book>();
        for (int i = 0; i < 1000; i++) {
            Book book = new Book();
            book.setTitle("The love");
            book.setAuthor("Trug");
            book.setImage(images[random.nextInt(11)]);
            mBookList.add(book);
        }
        mBookAdapter = new BookAdapter(mBookList, R.layout.card_book_item, getContext());
        mBinding.recyclerBook.setHasFixedSize(true);
        RecyclerView.LayoutManager manager = new GridLayoutManager(getContext(), 2);
        mBinding.recyclerBook.setLayoutManager(manager);
        mBinding.recyclerBook.setAdapter(mBookAdapter);
        return view;
    }
}
