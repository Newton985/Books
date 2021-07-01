package com.fineapps.books.models;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Map;

public class Volume {

    @Expose
    VolumeInfo volumeInfo;
    String id;
    String selfLink;

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }
}
