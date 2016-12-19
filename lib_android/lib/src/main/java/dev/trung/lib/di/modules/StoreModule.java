package dev.trung.lib.di.modules;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dev.trung.lib.helper.ManagerPreferences;
import dev.trung.lib.interfaces.Realm;

/**
 * trung on 12/19/2016.
 */
@Module
public class StoreModule {
    @Singleton
    @Provides
    ManagerPreferences providePreferences(Application application) {
        return new ManagerPreferences(application.getSharedPreferences(ManagerPreferences.PREF_NAME, ManagerPreferences.PRIVATE_MODE));
    }

    @Singleton
    @Provides
    Realm provideRealm() {
        return null;
    }
}
