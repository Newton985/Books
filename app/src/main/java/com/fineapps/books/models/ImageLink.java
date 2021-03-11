package com.fineapps.books.models;

import com.google.gson.annotations.Expose;

public class ImageLink {

    @Expose
    String thumbnail;


    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
