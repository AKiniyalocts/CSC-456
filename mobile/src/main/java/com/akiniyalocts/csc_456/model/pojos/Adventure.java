package com.akiniyalocts.csc_456.model.pojos;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by anthony on 8/20/15.
 */
public class Adventure extends RealmObject{

    private String title;

    private String xp;

    private String overview;

    private String date;

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

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
