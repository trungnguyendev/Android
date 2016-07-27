package dev.trung.sqlite;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import dev.trung.sqlite.dao.DbHelper;
import dev.trung.sqlite.databinding.ActivityMainBinding;
import dev.trung.sqlite.listener.BookListener;
import dev.trung.sqlite.listener.DeleteBookDialogListener;
import dev.trung.sqlite.ui.dialog.DeleteBookDialog;
import dev.trung.sqlite.ui.fragment.BookFragment;
import dev.trung.sqlite.ui.fragment.OperationBookFragment;
import dev.trung.sqlite.util.Constant;
import dev.trung.sqlite.util.LogUtil;
import dev.trung.sqlite.util.ToastUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, BookListener, DeleteBookDialogListener {
    private ActivityMainBinding mBinding;
    private BookFragment mBookFragment;
    private OperationBookFragment mOperationBookFragment;
    private ActionBar mActionBar;
    private DbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mActionBar = getSupportActionBar();
        mBookFragment = new BookFragment(this);

        if (savedInstanceState != null) {
            Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment_container);
            if (fragment != null)
                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(fragment)
                        .commit();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, mBookFragment, Constant.TAG_BOOK_FRAGMENT)
                .commit();
        mBinding.fabBook.setOnClickListener(this);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mBinding.fabBook.getVisibility() == View.GONE) {
            mActionBar.setTitle(R.string.app_name);
            mBinding.fabBook.setVisibility(View.VISIBLE);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_book:
                mOperationBookFragment = OperationBookFragment.newInstance(OperationBookFragment.ARG_DEFAULT);
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, mOperationBookFragment)
                        .addToBackStack(null)
                        .commit();
                mBinding.fabBook.setVisibility(View.GONE);
                mActionBar.setTitle(R.string.add_book_title);
                break;
            default:
        }
    }

    @Override
    public void updateBook(int rowId) {
        mOperationBookFragment = OperationBookFragment.newInstance(rowId);
        if (!mOperationBookFragment.isAdded()) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, mOperationBookFragment, Constant.TAG_OPERATION_FRAGMENT)
                    .addToBackStack(null)
                    .commit();
        }
        mBinding.fabBook.setVisibility(View.GONE);
        mActionBar.setTitle(R.string.update_book_title);
    }

    @Override
    public void deleteBook(int rowId, int position) {
        DeleteBookDialog dialog = new DeleteBookDialog(this, this, rowId, position);
        dialog.show(getSupportFragmentManager(), Constant.DIALOG_DELETE);
    }

    @Override
    public void onOKClick(int rowId, int position) {
        mDbHelper = new DbHelper(this);
        mBookFragment.remove(position);
        mDbHelper.delete(rowId);
    }

    @Override
    public void onCancleClick() {
        ToastUtil.Toast(this, "cancle!");
    }
}