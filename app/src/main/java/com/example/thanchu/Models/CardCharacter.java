package com.example.thanchu.Models;

import java.util.HashMap;

public class CardCharacter extends Card{
    private String hp;

    @Override
    public HashMap<String, Object> convertHashMap() {
        HashMap<String, Object> hashMap = super.convertHashMap();
        hashMap.put("hp", hp);
        return hashMap;
    }

    public CardCharacter() {
    }

    public CardCharacter(String name, String image, String artist, String description, String hp) {
        super(name, image, artist, description);
        this.hp = hp;
    }

    public CardCharacter(String hp) {
        this.hp = hp;
    }

    public String getHp() {
        return hp;
    }
}
