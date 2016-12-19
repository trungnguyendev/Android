package dev.trung.lib.di;

import javax.inject.Singleton;

import dagger.Component;
import dev.trung.lib.di.modules.ApiModule;
import dev.trung.lib.di.modules.AppModule;
import dev.trung.lib.di.modules.StoreModule;
import retrofit2.Retrofit;

/**
 * trung on 12/19/2016.
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class, StoreModule.class})
public interface ApiComponent {
    Retrofit retrofit();
}