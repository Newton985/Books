package com.fineapps.books.models;

import com.google.gson.annotations.Expose;

import java.util.List;

public class VolumeInfo {

    @Expose
    String title;

    @Expose
    String subtitle;

    @Expose
    List<String> authors;

    @Expose
    String description;

    @Expose
    ImageLink imageLinks;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageLink getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(ImageLink imageLinks) {
        this.imageLinks = imageLinks;
    }
}
