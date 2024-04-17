package com.example.thanchu.Models;

public class CardCharacter extends Card{
    private int hp;

    public CardCharacter(String name, String image, String artist, String description, int hp) {
        super(name, image, artist, description);
        this.hp = hp;
    }

    public CardCharacter(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }
}
