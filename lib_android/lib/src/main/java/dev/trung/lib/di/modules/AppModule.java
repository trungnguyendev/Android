package dev.trung.lib.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * trung on 12/19/2016.
 */
@Module
public class AppModule {
    private Application application;

    @Singleton
    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    Application provideApplication() {
        return application;
    }
}
