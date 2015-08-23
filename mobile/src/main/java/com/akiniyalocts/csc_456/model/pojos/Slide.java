package com.akiniyalocts.csc_456.model.pojos;

import io.realm.RealmObject;

/**
 * Created by anthony on 8/21/15.
 */
public class Slide extends RealmObject {
    private String slide;

    public String getSlide() {
        return slide;
    }

    public void setSlide(String slide) {
        this.slide = slide;
    }
}
