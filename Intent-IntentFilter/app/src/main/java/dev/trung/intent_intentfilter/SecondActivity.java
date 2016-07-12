package dev.trung.intent_intentfilter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import dev.trung.intent_intentfilter.databinding.ActivitySecondBinding;
import dev.trung.intent_intentfilter.util.Constant;
import dev.trung.intent_intentfilter.util.LogUtil;

public class SecondActivity extends AppCompatActivity {
    private ActivitySecondBinding bin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        bin = DataBindingUtil.setContentView(SecondActivity.this,R.layout.activity_second);


        bin.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent();
                in.putExtra(Constant.EXTRA_RETURN,bin.editMessage.getText().toString().trim());
                setResult(RESULT_OK,in);
                SecondActivity.this.finish();
            }
        });
    }
}
