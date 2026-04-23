package com.example.sportsnewsapp1.model;

public class News {
    public String title;
    public String description;
    public int image;
    public String category;

    public News(String title, String description, int image, String category) {
        this.title = title;
        this.description = description;
        this.image = image;
        this.category = category;
    }
}
