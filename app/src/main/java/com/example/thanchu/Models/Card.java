package com.example.thanchu.Models;

import java.security.Key;

public class Card {
    public int id;
    public String name;
    public String image;
    public String artist;
    public String description;

    public Card(int id, String name, String image, String artist, String description) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.artist = artist;
        this.description = description;
    }

    public Card() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
