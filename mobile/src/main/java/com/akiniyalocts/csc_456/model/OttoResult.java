package com.akiniyalocts.csc_456.model;

import java.util.List;

/**
 * Created by anthony on 8/21/15.
 */
public class OttoResult<T> {
    public List<T> items;

    public int type;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
