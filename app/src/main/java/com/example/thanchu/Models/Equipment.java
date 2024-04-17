package com.example.thanchu.Models;

public class Equipment {
    private int id;
    private int equipmentTypeId;
    private String name;
    private String image;
    private int stats;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(int equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
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

    public int getStats() {
        return stats;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
