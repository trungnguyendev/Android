package dev.trung.sqlite.ui.fragment;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.io.ByteArrayOutputStream;

import dev.trung.sqlite.R;
import dev.trung.sqlite.dao.DbHelper;
import dev.trung.sqlite.databinding.FragmentBookBinding;
import dev.trung.sqlite.databinding.FragmentOperationBookBinding;
import dev.trung.sqlite.model.Book;

/**
 * Created by trungnv on 7/23/2016.
 */

public class OperationBookFragment extends Fragment {
    private FragmentOperationBookBinding mBinding;
    private final static String ARG_ROWID = "ARG_ROWID";
    private final static int REQUEST_CODE = 10;
    public final static int ARG_DEFAULT = -1;
    private DbHelper mDbHelper;

    public OperationBookFragment() {
    }

    public static OperationBookFragment newInstance(int rowId) {
        OperationBookFragment fragment = new OperationBookFragment();
        if (rowId != ARG_DEFAULT) {
            Bundle args = new Bundle();
            args.putInt(ARG_ROWID, rowId);
            fragment.setArguments(args);
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_operation_book, container, false);
        mBinding = DataBindingUtil.bind(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null && args.getInt(ARG_ROWID) != -1) {
            Book book = new DbHelper(getContext()).getById(args.getInt(ARG_ROWID));
            if (book != null) {
                mBinding.textTitle.setText(book.getTitle());
                mBinding.textContent.setText(book.getContent());
                mBinding.textAuthor.setText(book.getAuthor());
                Glide.with(getContext()).load(book.getImage()).into(mBinding.imageThumbnail);
            }
        }
    }

    public void addBook() {
        Book book = new Book();
        book.setTitle(mBinding.textTitle.getText().toString().trim());
        book.setContent(mBinding.textContent.getText().toString().trim());
        book.setAuthor(mBinding.textAuthor.getText().toString().trim());
        book.setImage(R.drawable.album2);
        if (book != null)
            mDbHelper.insert(book);
    }

    @Override
    public void onResume() {
        super.onResume();
        mDbHelper = new DbHelper(getContext());
        mBinding.imageThumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                getActivity().startActivityForResult(intent, REQUEST_CODE);
            }
        });
        mBinding.btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle args = getArguments();
                if (args != null && args.getInt(ARG_ROWID) != -1) {
                    updateBook();
                }
                addBook();
            }
        });
    }

    public void updateBook() {
        Book book = new Book();
        book.setId(getArguments().getInt(ARG_ROWID));
        book.setTitle(mBinding.textTitle.getText().toString().trim());
        book.setContent(mBinding.textContent.getText().toString().trim());
        book.setAuthor(mBinding.textAuthor.getText().toString().trim());
        book.setImage(R.drawable.album2);

        if (book != null)
            mDbHelper.update(book);
    }
}
