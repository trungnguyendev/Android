package dev.trung.lib.interfaces;

import io.realm.RealmModel;

/**
 * trung on 12/16/2016.
 */

public interface Realm {
    void create(Class<RealmModel> aClass);

    void delete(Class<?> aClass);

    void update(Class<?> aClass);

    void get(long id);

    void getAll();
}
