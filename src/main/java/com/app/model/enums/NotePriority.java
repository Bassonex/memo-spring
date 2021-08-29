package com.app.model.enums;

public enum NotePriority {
    Low("Low"),
    Moderate("Moderate"),
    Medium("Medium"),
    High("High"),
    Extreme("Extreme");

    private String name;

    // Constructor

    NotePriority(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
