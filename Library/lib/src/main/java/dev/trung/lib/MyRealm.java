package dev.trung.lib;

import dev.trung.lib.store.Realm;
import io.realm.RealmModel;
import io.realm.RealmObject;

/**
 * trung on 12/16/2016.
 */

public class MyRealm implements Realm {
    private io.realm.Realm realm;

    public MyRealm(io.realm.Realm realm) {
        this.realm = realm;
    }


    @Override
    public void create(final Class<RealmModel> aClass) {
        realm.executeTransactionAsync(new io.realm.Realm.Transaction() {
            @Override
            public void execute(io.realm.Realm realm) {
                realm.createObject(aClass);
            }
        });
    }

    @Override
    public void delete(Class<?> aClass) {

    }

    @Override
    public void update(Class<?> aClass) {

    }

    @Override
    public void get(long id) {

    }

    @Override
    public void getAll() {

    }
}
