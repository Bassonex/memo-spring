package com.app.model.enums;

public enum NoteCategory {
    HomeWork("HomeWork"),
    JobTask("JobTask"),
    ShoppingList("ShoppingList");


    private String name;

    // Constructor

    NoteCategory(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return name;
    }
}
