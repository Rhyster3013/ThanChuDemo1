package com.example.thanchu.Models;
// loại trang bị

public class EquipmentType {
    private int id;
    private String name;
    private String borderColor;
    private String borderSymbol;
    private int functionTypeId;

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

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public String getBorderSymbol() {
        return borderSymbol;
    }

    public void setBorderSymbol(String borderSymbol) {
        this.borderSymbol = borderSymbol;
    }

    public int getFunctionTypeId() {
        return functionTypeId;
    }

    public void setFunctionTypeId(int functionTypeId) {
        this.functionTypeId = functionTypeId;
    }
}
