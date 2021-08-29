package com.app.services;

import com.app.dao.NoteDao;
import com.app.dao.NoteDaoImpl;
import com.app.dao.UserDao;
import com.app.model.Note;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class NoteService {

    // NOTES FROM DATABASES - TEST
    @Autowired
    private NoteDao noteDao;

    public List<Note> getNotesDb() {
        return noteDao.getNotesDb();
    }


    // LOCAL NOTES
    NoteDaoImpl noteDaoImpl = new NoteDaoImpl();

    // Created notes lay here
    public List<Note> getNotes() {
        return noteDaoImpl.getAllNotes();
    }

    // This method looks for user in Note array, if he exist there then prints his notes
    public List<Note> getUserNotes(String userName) {
        return noteDaoImpl.getUserNotes(userName);
    }

    public void addNote(Note note) {
        noteDaoImpl.addNote(note);
    }

    // Note form validation
    public Note validateNote(Note note) {
        if (note.getTitle().isEmpty() || note.getNote().isEmpty())
                //|| note.getUserName().getFirstName().isEmpty()
                //|| note.getUserName().getLastName().isEmpty())
        {
            System.out.println("Validation failed!");
            return null;
        }
        //noteDao.storeNotes(note);
        //noteDaoImpl.addNote(note);
        System.out.println("Validation passed!");
        return note;
    }

}
