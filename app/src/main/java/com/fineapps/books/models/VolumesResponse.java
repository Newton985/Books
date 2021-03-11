package com.fineapps.books.models;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Map;

public class VolumesResponse {

@Expose
    String kind;

@Expose
    int totalItems;
@Expose
    List<Volume> items;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Volume> getItems() {
        return items;
    }

    public void setItems(List<Volume> items) {
        this.items = items;
    }
}
