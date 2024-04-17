package com.example.thanchu.Models;

import java.util.List;

public class GameCard {
    private int id;
    private String name;
    private String image;
    private String description;
    private List<FunctionCard> functionCards;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<FunctionCard> getFunctionCards() {
        return functionCards;
    }

    public void setFunctionCards(List<FunctionCard> functionCards) {
        this.functionCards = functionCards;
    }
}
