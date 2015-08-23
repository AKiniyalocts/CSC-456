package com.akiniyalocts.csc_456.model.pojos;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by anthony on 8/20/15.
 */
public class Badge extends RealmObject{

    private String title;

    private String xp;

    private String badge;

    private String description;

    @PrimaryKey
    private int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}