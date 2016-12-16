package dev.trung.lib;

import dev.trung.lib.store.Realm;
import io.realm.RealmObject;

/**
 * trung on 12/16/2016.
 */

public class Main {
    public Main() {
        Realm realm = new MyRealm(io.realm.Realm.getDefaultInstance());
    }
}
