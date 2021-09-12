package com.app.services;

import com.app.dao.NoteDao;
import com.app.dao.UserDao;
import com.app.model.Note;
import com.app.model.User;
import com.app.model.enums.NoteCategory;
import com.app.model.enums.NotePriority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private NoteDao noteDao;

    public List<Note> getNotes(){
        return noteDao.getNotesDb();
    }

    public List<Note> getUserNotes(long id){
        return noteDao.getUserNotesDb(id);
    }

    public List<Note> getNotesByPriority(NotePriority prio){
        return noteDao.getNotesByPriority(prio);
    }

    public List<Note> getNotesByCategory(NoteCategory cat){
        return noteDao.getNotesByCategory(cat);
    }

    public void storeNote(Note note){

        noteDao.storeNotes(note);
    }

    @Autowired
    private UserDao userDao;

    public List<User> getUsers(){
        return userDao.getUsersDb();
    }




    // @Autowired
    // private NoteCategory category;
//
    // public NoteCategory noteCategoryEnum(){
    //     return NoteCategory.valueOf(category.name());
    // }
}
