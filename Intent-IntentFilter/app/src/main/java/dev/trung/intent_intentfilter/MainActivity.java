package dev.trung.intent_intentfilter;

import android.app.SearchManager;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import dev.trung.intent_intentfilter.databinding.ActivityMainBinding;
import dev.trung.intent_intentfilter.databinding.ActivitySecondBinding;
import dev.trung.intent_intentfilter.util.Constant;
import dev.trung.intent_intentfilter.util.LogUtil;
import dev.trung.intent_intentfilter.util.ToastUtil;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 10;
    private ActivityMainBinding binding;
    private Intent intent;
    private boolean mIsStartActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        final ListAdapter ad = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.intents));
        binding.listIntent.setAdapter(ad);
        binding.listIntent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    //start activity
                    case 0:
                        intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra(Constant.EXTRA_DATA, binding.editMessage.getText().toString().trim());
                        startActivity(intent);
                        break;
                    //share data
                    case 1:
                        intent = new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_TEXT, binding.editMessage.getText().toString().trim());
                        startActivity(intent);
                        break;
                    // open Browser
                    case 2:
                        intent = new Intent(Intent.ACTION_WEB_SEARCH);
                        intent.putExtra(SearchManager.QUERY, Uri.parse(binding.editMessage.getText().toString().trim()));
                        startActivity(intent);
                        break;
                    //call someone
                    case 3:
                        intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + binding.editMessage.getText().toString().trim()));
                        try {
                            startActivity(intent);
                        } catch (Exception e) {
                            LogUtil.d(e);
                        }
                        break;
                    //dial
                    case 4:
                        intent = new Intent(Intent.ACTION_DIAL,
                                Uri.parse("tel:" + binding.editMessage.getText().toString().trim()));
                        startActivity(intent);
                        break;
                    //show map
                    case 5:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:50.123,7.1434?z=19"));
                        startActivity(intent);
                        break;
                    //Search on Map
                    case 6:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("geo:0,0?q="+binding.editMessage.getText().toString().trim()));
                        startActivity(intent);
                        break;
                    //Take picture
                    case 7:
                        intent = new Intent(Intent.ACTION_GET_CONTENT);
                        intent.setType("image/*");
                        startActivityForResult(intent,REQUEST_CODE);
                        break;
                    //
                    case 8:
                        intent = new Intent(Intent.ACTION_VIEW,
                                Uri.parse("content://contacts/people/"));
                        startActivity(intent);
                        break;
                    case 9:
                        intent = new Intent(Intent.ACTION_EDIT,
                                Uri.parse("content://contacts/people/1"));
                        startActivity(intent);
                        break;
                }
            }
        });


//        binding.buttonStartActivity.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent in = new Intent(MainActivity.this, SecondActivity.class);
//                in.putExtra(Constant.EXTRA_DATA, binding.editMessage.getText().toString().trim());
//                startActivityForResult(in, REQUEST_CODE);
//                LogUtil.d("onCreate");
//            }
//        });
//        binding.buttonShareData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                shareIntent.setType("text/plain");
//                shareIntent.putExtra(Intent.EXTRA_TEXT, binding.editMessage.getText().toString().trim());
//                startActivity(shareIntent);
//            }
//        });
//        binding.buttonSelectImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent selectImageIntent = new Intent();
//                selectImageIntent.setType("image/*");
//                selectImageIntent.setAction(Intent.ACTION_GET_CONTENT);
//                selectImageIntent.addCategory(Intent.CATEGORY_OPENABLE);
//                startActivityForResult(selectImageIntent, REQUEST_CODE);
//            }
//        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        InputStream stream = null;
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra(Constant.EXTRA_RETURN)) {
                String result = data.getExtras().getString(Constant.EXTRA_RETURN);
                ToastUtil.Toast(MainActivity.this, result);
            } else {
                ToastUtil.Toast(MainActivity.this, data.getDataString());
                try {
                    stream = getContentResolver().openInputStream(data.getData());
                    Bitmap bm = BitmapFactory.decodeStream(stream);
                    binding.imagePick.setImageBitmap(bm);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    if (stream != null) {
                        try {
                            stream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
                LogUtil.d(data.getDataString());
            }
        }
    }
}
