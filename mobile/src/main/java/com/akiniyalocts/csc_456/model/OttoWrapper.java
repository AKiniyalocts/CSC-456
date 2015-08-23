package com.akiniyalocts.csc_456.model;

import java.util.List;

/**
 * Created by anthony on 8/21/15.
 */
public class OttoWrapper<T> {
    public List<T> items;

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
