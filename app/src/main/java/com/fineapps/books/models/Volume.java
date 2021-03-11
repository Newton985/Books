package com.fineapps.books.models;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Map;

public class Volume {

    @Expose
    VolumeInfo volumeInfo;


    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }


}
