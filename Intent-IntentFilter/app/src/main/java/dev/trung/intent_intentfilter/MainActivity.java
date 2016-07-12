package dev.trung.intent_intentfilter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.InputStream;

import dev.trung.intent_intentfilter.databinding.ActivityMainBinding;
import dev.trung.intent_intentfilter.databinding.ActivitySecondBinding;
import dev.trung.intent_intentfilter.util.Constant;
import dev.trung.intent_intentfilter.util.LogUtil;
import dev.trung.intent_intentfilter.util.ToastUtil;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 10;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);

        binding.buttonStartActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, SecondActivity.class);
                in.putExtra(Constant.EXTRA_DATA, binding.editMessage.getText().toString().trim());
                startActivityForResult(in, REQUEST_CODE);
                LogUtil.d("onCreate");
            }
        });
        binding.buttonShareData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_TEXT, binding.editMessage.getText().toString().trim());
                startActivity(shareIntent);
            }
        });
        binding.buttonSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent selectImageIntent = new Intent();
                selectImageIntent.setType("image/*");
                selectImageIntent.setAction(Intent.ACTION_GET_CONTENT);
                selectImageIntent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(selectImageIntent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        InputStream stream = null;
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            if (data.hasExtra(Constant.EXTRA_RETURN)) {
                String result = data.getExtras().getString(Constant.EXTRA_RETURN);
                ToastUtil.Toast(MainActivity.this, result);
            }else {
             ToastUtil.Toast(MainActivity.this,data.getDataString());
            }
        }
    }
}
