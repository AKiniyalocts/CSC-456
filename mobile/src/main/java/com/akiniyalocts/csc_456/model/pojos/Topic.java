package com.akiniyalocts.csc_456.model.pojos;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by anthony on 8/21/15.
 */
public class Topic extends RealmObject{

    @SerializedName(" ")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
