package com.fineapps.books.models;

import com.google.gson.annotations.Expose;

import java.util.List;
import java.util.Map;

public class VolumeInfo {

    @Expose
    String title;

    @Expose
    String subtitle;

    @Expose
    List<String> authors;

    @Expose
    String publisher;

    @Expose
    String publishedDate;

    @Expose
    List<Map<String, String>> industryIdentifiers;

    @Expose
    int pageCount;

    @Expose
    double averageRating;

    @Expose
    String language;

    @Expose
    List<String> categories;

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

    public List<Map<String, String>> getIndustryIdentifiers() {
        return industryIdentifiers;
    }

    public void setIndustryIdentifiers(List<Map<String, String>> industryIdentifiers) {
        this.industryIdentifiers = industryIdentifiers;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(int averageRating) {
        this.averageRating = averageRating;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }
}
