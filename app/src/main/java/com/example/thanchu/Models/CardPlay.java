package com.example.thanchu.Models;

import java.util.HashMap;

public class CardPlay extends Card{
    private int number;
    private String color;
    private String element;

    @Override
    public HashMap<String, Object> convertHashMap() {
        HashMap<String, Object> hashMap = super.convertHashMap();
        hashMap.put("number", number);
        hashMap.put("color", color);
        hashMap.put("element", element);
        return hashMap;
    }

    public CardPlay(String name, String image, String artist, String description, int number, String color, String element) {
        super(name, image, artist, description);
        this.number = number;
        this.color = color;
        this.element = element;
    }

    public CardPlay(int number, String color, String element) {
        this.number = number;
        this.color = color;
        this.element = element;
    }

    public CardPlay(String name, String image, String artist, String description) {
        super(name, image, artist, description);
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
