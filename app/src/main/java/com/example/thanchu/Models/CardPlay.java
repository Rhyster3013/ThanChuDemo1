package com.example.thanchu.Models;

import java.util.HashMap;

public class CardPlay extends Card{
    private int number;
    private String color;
    private String element;
    private String type;

    @Override
    public HashMap<String, Object> convertHashMap() {
        HashMap<String, Object> hashMap = super.convertHashMap();
        hashMap.put("number", number);
        hashMap.put("color", color);
        hashMap.put("element", element);
        hashMap.put("type", type);
        return hashMap;
    }

    public CardPlay(String name, String image, String artist, String description, int number, String color, String element, String type) {
        super(name, image, artist, description);
        this.number = number;
        this.color = color;
        this.element = element;
        this.type = type;
    }

    public CardPlay(String name, String image, String artist, String description) {
        super(name, image, artist, description);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }
}
