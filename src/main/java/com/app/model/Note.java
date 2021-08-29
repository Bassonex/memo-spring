package com.app.model;

import com.app.model.enums.NoteCategory;
import com.app.model.enums.NotePriority;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

// Object
public class Note {

    private long id;
    private long userId;
    private String note;
    private String title;
    private NotePriority notePriority;
    private User user;
    private NoteCategory category;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    // Constructors
    public Note(String note, NotePriority notePriority, String title) {
        this.note = note;
        this.notePriority = notePriority;
        this.title = title;
    }

    public Note(String note, NotePriority notePriority) {
        this.note = note;
        this.notePriority = notePriority;
    }

    public Note(String note) {
        this.note = note;
    }

    public Note(String note, NoteCategory category, LocalDateTime dateTime, User user, NotePriority notePriority, String title) {
        this.note = note;
        this.category = category;
        this.dateTime = dateTime;
        this.notePriority = notePriority;
        this.title = title;
        this.user = user;
    }

    public Note(Long userId, String note, NoteCategory category, LocalDateTime dateTime, User user, NotePriority notePriority, String title) {
        this.userId = userId;
        this.note = note;
        this.category = category;
        this.dateTime = dateTime;
        this.user = user;
        this.notePriority = notePriority;
        this.title = title;

    }

    // for creation form only
    public Note() {
    }

    // Getters-Setters


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public NotePriority getNotePriority() {
        return notePriority;
    }

    public void setNotePriority(NotePriority notePriority) {
        this.notePriority = notePriority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(NoteCategory category) {
        this.category = category;
    }

    public NoteCategory getCategory() {
        return category;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUserName() {
        user.getFullName();
        return user;
    }

    public User getUser(){
        return user;
    }

    public void setUserName(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Custom method for homework 1

    public void printNote() {
        System.out.println("Note: " + note);
        System.out.println("----------------------------------");
    }

    public void printFullNote() {
        System.out.println("Priority: " + notePriority);
        System.out.println("Note: " + note);
        System.out.println("More info: '" + title + "'");
        System.out.println("----------------------------------");
    }
}




