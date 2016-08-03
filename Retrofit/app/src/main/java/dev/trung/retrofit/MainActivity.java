package dev.trung.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import dev.trung.retrofit.util.Util;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String result = Util.AssetJSONFile(this, "city.list.json");
        TextView textView = (TextView) findViewById(R.id.ms);
        textView.setText(result);
    }
}