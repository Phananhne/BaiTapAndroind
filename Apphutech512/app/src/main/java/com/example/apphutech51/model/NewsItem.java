package com.example.apphutech51.model;

public class NewsItem {

    private String title;
    private String url;
    private String imageUrl;

    public NewsItem(String title, String url, String imageUrl) {
        this.title = title;
        this.url = url;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) { this.title = title; }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) { this.url = url; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}