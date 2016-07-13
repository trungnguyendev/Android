package dev.trung.intent_intentfilter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import dev.trung.intent_intentfilter.databinding.ActivitySecondBinding;
import dev.trung.intent_intentfilter.util.Constant;
import dev.trung.intent_intentfilter.util.LogUtil;
import dev.trung.intent_intentfilter.util.ToastUtil;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding mbinding;
    private String mMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        mbinding = DataBindingUtil.setContentView(SecondActivity.this, R.layout.activity_second);
        Bundle dataIntent = getIntent().getExtras();
        if (dataIntent != null)
            mMessage = dataIntent.getString(Constant.EXTRA_DATA);
        mbinding.editMessage.setText(mMessage);
        ToastUtil.Toast(SecondActivity.this,mMessage);
        mbinding.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SecondActivity.this.finish();
            }
        });
    }
}
