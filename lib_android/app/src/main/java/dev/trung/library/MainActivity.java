package dev.trung.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dev.trung.lib.di.ApiComponent;
import dev.trung.lib.di.modules.ApiModule;
import dev.trung.lib.di.modules.AppModule;
import dev.trung.lib.di.DaggerApiComponent;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    Retrofit retrofit;
    private ApiComponent apiComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiComponent = DaggerApiComponent.builder().appModule(new AppModule(getApplication())).apiModule(new ApiModule("http://api.openweathermap.org", "ddf2d313c216e87b5319cfd6cea0c055")).build();
        retrofit = apiComponent.retrofit();
    }
}
