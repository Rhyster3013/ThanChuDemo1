package com.example.thanchu.Models;

import java.io.Serializable;
import java.security.Key;
import java.util.HashMap;

public class Card  implements Serializable {
    public String id;
    public String name;
    public String image;
    public String artist;
    public String description;


    public HashMap<String, Object> convertHashMap() {
        HashMap<String, Object> work = new HashMap<>();

        work.put("id", id);
        work.put("name", name);
        work.put("image", image);;
        work.put("artist", artist);;
        work.put("description", description);

        return work;
    }

    public Card(String name, String image, String artist, String description) {
        this.name = name;
        this.image = image;
        this.artist = artist;
        this.description = description;
    }

    public Card() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
