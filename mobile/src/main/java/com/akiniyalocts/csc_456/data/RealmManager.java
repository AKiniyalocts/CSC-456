package com.akiniyalocts.csc_456.data;

import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by anthony on 8/21/15.
 */
public class RealmManager<T extends RealmObject> {

    protected Context mContext;

    protected Realm realm;

    protected Class clazz;

    public RealmManager(Context context, Class clazz){
        mContext = context;
        this.clazz = clazz;
        realm = Realm.getInstance(mContext);
    }

    public RealmResults<T> select(){
        Realm realm = Realm.getInstance(mContext);

        return realm.where(clazz).findAll();
    }

    @SuppressWarnings("Unchecked")
    public RealmResults<T> queryByFieldname(@NonNull String fieldName, @NonNull String query){
        if(!fieldName.trim().isEmpty() && !query.trim().isEmpty()){
            return realm.where(clazz).contains(fieldName, query, false).findAll();
        }
            return null;
    }

    public void updateMultiple(final List<T> realmObjects){
        Realm realm = Realm.getInstance(mContext);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(realmObjects);

            }
        });
    }
}