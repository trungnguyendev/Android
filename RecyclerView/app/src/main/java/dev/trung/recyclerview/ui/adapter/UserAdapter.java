package dev.trung.recyclerview.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dev.trung.recyclerview.databinding.RycyclerUserItemBinding;
import dev.trung.recyclerview.models.User;

/**
 * Created by trungnv on 7/14/2016.
 */

public class UserAdapter extends BaseAdapter<User, UserAdapter.UserViewHolder> {

    public UserAdapter(List<User> mListUsers, int mLayout) {
        super(mListUsers, mLayout);
    }

    @Override
    protected void populateViewHolder(UserViewHolder viewHolder, User model, int position) {
        viewHolder.getBinding().textNameUser.setText(model.getName());
        viewHolder.getBinding().textDescription.setText(model.getDescription() + "-" + position);
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new UserViewHolder(v);
    }

    public class UserViewHolder extends BaseViewHolder<RycyclerUserItemBinding> {

        public UserViewHolder(View itemView) {
            super(itemView);
        }
    }
}
