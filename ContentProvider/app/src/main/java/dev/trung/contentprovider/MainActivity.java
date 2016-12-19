package dev.trung.contentprovider;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.util.ArrayList;
import java.util.List;

import dev.trung.contentprovider.R;
import dev.trung.contentprovider.databinding.ActivityMainBinding;
import dev.trung.contentprovider.model.Contact;
import dev.trung.contentprovider.ui.ContactAdapter;
import dev.trung.lib.di.DaggerApiComponent;
import dev.trung.lib.helper.ManagerPreferences;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private List<Contact> mContactList;
    private ContactAdapter mContactAdapter;
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        DaggerApiComponent.builder().apiModule()
        try {
            XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        mContactList = new ArrayList<Contact>();
        mBinding.btnShowContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showContacts();
            }
        });
    }

    private void showContacts() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
                showContactsPreview();
            } else {
                if (shouldShowRequestPermissionRationale(Manifest.permission.READ_CONTACTS)) {
                    Toast.makeText(this, "Read contacts permission is needed to show the Contacts", Toast.LENGTH_LONG).show();
                }
                requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
            }
        }
    }

    private void showContactsPreview() {
        Cursor cursor = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                if (!name.isEmpty()) {
                    Contact contact = new Contact(name);
                    mContactList.add(contact);
                }
            } while (cursor.moveToNext());
        }
        if (mContactList != null) {
            mContactAdapter = new ContactAdapter(mContactList);
            mBinding.recyclerContacts.setHasFixedSize(true);
            RecyclerView.LayoutManager manager = new LinearLayoutManager(MainActivity.this);
            mBinding.recyclerContacts.setLayoutManager(manager);
            mBinding.recyclerContacts.setAdapter(mContactAdapter);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_READ_CONTACTS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    showContactsPreview();
                } else {
                    Toast.makeText(this, "Permission was not granted", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }
}
