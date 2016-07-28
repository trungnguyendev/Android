package dev.trung.contentprovider.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import dev.trung.contentprovider.R;
import dev.trung.contentprovider.databinding.RecyclerContactItemBinding;
import dev.trung.contentprovider.model.Contact;

/**
 * Created by trungnv on 7/28/2016.
 */

public class ContactAdapter extends Adapter<Contact, ContactAdapter.ContactHolder> {

    public ContactAdapter(List<Contact> mList) {
        super(mList);
    }

    @Override
    protected void populateViewHolder(ContactHolder viewHolder, Contact model, int position) {
        viewHolder.getBinding().txtName.setText(model.getName());
    }


    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_contact_item, parent, false);
        return new ContactHolder(view);
    }

    public class ContactHolder extends ViewHolder<RecyclerContactItemBinding> {
        public ContactHolder(View itemView) {
            super(itemView);
        }
    }
}
