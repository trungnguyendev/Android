package dev.trung.preference;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import dev.trung.preference.databinding.ActivityMainBinding;
import dev.trung.preference.ui.PrefFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                if (getFragmentManager().findFragmentById(R.id.frame_container) == null) {
                    PrefFragment mPrefsFragment = new PrefFragment();
                    getFragmentManager().beginTransaction().replace(R.id.frame_container, mPrefsFragment).addToBackStack(null).commit();
                }
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}
