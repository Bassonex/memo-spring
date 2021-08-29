package com.app.dao;

import com.app.model.Note;
import com.app.model.enums.NoteCategory;
import com.app.model.enums.NotePriority;
import com.app.services.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.app.model.User;

public class NoteDaoImpl {
    List<Note> noteList = new ArrayList<>();
    UserService users = new UserService();
    List<User> user = users.getUsers();

    public List<Note> getUserNotes(String lalala) {
        List<Note> userNotes = new ArrayList<>();

        List<Note> notes = getAllNotes();
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i).getUserName().getEmail().toLowerCase(Locale.ROOT).equals(lalala)) { // changed to email, was [ notes.get(i).getUserName().getFullName() ]
                userNotes.add(notes.get(i));
                System.out.println("In IF");
            }
        }
        return userNotes;
    }

    public List<Note> getAllNotes() {
        if (noteList.size() == 0) {
            this.startFiller();
        }
        return noteList;
    }

    public void startFiller() {

        noteList.add(new Note("Take a walk to the Skyrim landscape and make chaos to citizens.", NoteCategory.JobTask, LocalDateTime.now(), user.get(0), NotePriority.Low, "'find dragonborn'"));
        noteList.add(new Note("Write a book about programming in Java.", NoteCategory.HomeWork, LocalDateTime.now(), user.get(1), NotePriority.High, "'get info from course'"));
        noteList.add(new Note("Rush B and don't ask questions, just RUSH B!", NoteCategory.JobTask, LocalDateTime.now(), user.get(2), NotePriority.Medium, "'die while rushing'"));
        noteList.add(new Note("Request two number 9s, a number 9 large, a number 6 with extra dip, a number 7, two number 45s, one with cheese, and a large soda.",
                NoteCategory.ShoppingList, LocalDateTime.now(), user.get(2), NotePriority.Extreme, "'eat everything'"));
    }

    public void addNote(Note note) {
        noteList.add(note);
    }
}
