package com.example.thanchu.Models;

public class FunctionCard {
    private int id;
    private int functionTypeId;
    private int blood;
    private int inheritance;
    private int gameCardId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFunctionTypeId() {
        return functionTypeId;
    }

    public void setFunctionTypeId(int functionTypeId) {
        this.functionTypeId = functionTypeId;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getInheritance() {
        return inheritance;
    }

    public void setInheritance(int inheritance) {
        this.inheritance = inheritance;
    }

    public int getGameCardId() {
        return gameCardId;
    }

    public void setGameCardId(int gameCardId) {
        this.gameCardId = gameCardId;
    }
}
