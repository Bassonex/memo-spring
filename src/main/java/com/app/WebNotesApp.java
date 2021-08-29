package com.app;


import com.app.model.Note;
import com.app.model.User;
import com.app.model.enums.NoteCategory;
import com.app.model.enums.NotePriority;
import com.app.services.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class WebNotesApp {
    // Main Method
    public static void main(String[] args) {

        //homeWork1(args);
        homeWork2(args);
        SpringApplication.run(WebNotesApp.class, args);
    }

    // First Homework
    public static void homeWork1(String[] args) {

        User user = new User("Oleg", "Glebov", "ggwp@inbox.lv", "+37122222222");
        User userTwo = new User("Jesus", "Christ", "wpgg@inbox.lv", "+37122222222");
        User userThree = new User("Milana", "Borisovna", "lol@inbox.lv", "+37122222222");

        Note products = new Note("Buy milk and bread!");
        Note jobTaskDesc = new Note("Call Gabe Newell and ask about Half-Life 3 development.");
        Note homeWorkDesc = new Note("Do your homework, math, physic and geometry", NotePriority.High, "get help from friend");

        user.printFullName();
        System.out.println(NoteCategory.ShoppingList);
        products.printNote();
        System.out.println();

        userTwo.printFullName();
        System.out.println(NoteCategory.JobTask);
        jobTaskDesc.printNote();
        System.out.println();

        userThree.printFullName();
        System.out.println(NoteCategory.HomeWork);
        homeWorkDesc.printFullNote();

    }

    // Second Homework
    public static void homeWork2(String[] args) {

        // Notes
        NoteService notes = new NoteService();
        List<Note> allNotes = notes.getNotes();

        // Print all notes
        for (int i = 0; i < allNotes.size(); i++) {
            System.out.println("Category: " + allNotes.get(i).getCategory());
            System.out.println("Note: " + allNotes.get(i).getNote());
            System.out.println("Date: " + allNotes.get(i).getDateTime());
            System.out.println("Author: " + allNotes.get(i).getUserName().getFullName());
            System.out.println("Priority: " + allNotes.get(i).getNotePriority());
            System.out.println("More info: " + allNotes.get(i).getTitle());
            System.out.println("------------------------------------------------------");
        }

        // Get notes for special user
        for (int i = 0; i < allNotes.size(); i++) {
            // Check if there is any notes for this user
            if (allNotes.get(i).getUserName().getFullName().equals("Big Smoke")) {
                // Print founded notes
                System.out.println(allNotes.get(i).getUserName().getFirstName() + "'s" + " notes: ");
                System.out.println("Note: " + allNotes.get(i).getNote());
            }
        }
    }
}


