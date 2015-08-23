package com.akiniyalocts.csc_456.model.pojos;


import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by anthony on 8/21/15.
 */
public class Reading extends RealmObject{

    private RealmList<RealmString> strings;

    public RealmList<RealmString> getStrings() {
        return strings;
    }

    public void setStrings(RealmList<RealmString> strings) {
        this.strings = strings;
    }
}
