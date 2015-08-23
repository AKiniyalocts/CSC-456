package com.akiniyalocts.csc_456.model.pojos;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by anthony on 8/20/15.
 */
public class Chapter extends RealmObject{

    @PrimaryKey
    private String date;

    private RealmList<RealmString> readings;

    private RealmList<RealmString> topics;

    private RealmList<RealmString> slides;

    @SerializedName("boss-fight")
    private boolean boss_fight;

    @SerializedName("no-class")
    private boolean no_class;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public RealmList<RealmString> getReadings() {
        return readings;
    }

    public void setReadings(RealmList<RealmString> readings) {
        this.readings = readings;
    }

    public RealmList<RealmString> getTopics() {
        return topics;
    }

    public void setTopics(RealmList<RealmString> topics) {
        this.topics = topics;
    }

    public RealmList<RealmString> getSlides() {
        return slides;
    }

    public void setSlides(RealmList<RealmString> slides) {
        this.slides = slides;
    }

    public boolean isBoss_fight() {
        return boss_fight;
    }

    public void setBoss_fight(boolean boss_fight) {
        this.boss_fight = boss_fight;
    }

    public boolean isNo_class() {
        return no_class;
    }

    public void setNo_class(boolean no_class) {
        this.no_class = no_class;
    }
}
