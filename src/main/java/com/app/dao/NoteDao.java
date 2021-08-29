package com.app.dao;


import com.app.model.Note;
import com.app.model.User;
import com.app.model.enums.NoteCategory;
import com.app.model.enums.NotePriority;
import com.app.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class NoteDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //Get notes from database
    public List<Note> getNotesDb() {
        RowMapper<Note> rowMapper = (rs, i) -> mapNotes(rs);
        return jdbcTemplate.query("SELECT u.first_name, u.last_name, u.email, u.phone, n.user_id, n.title, n.note, n.note_priority, n.note_category, n.date_time " +
                "FROM notes n " +
                "LEFT OUTER JOIN users u ON n.user_id = u.id", rowMapper);
    }

    public List<Note> getUserNotesDb(long userId) {
        RowMapper<Note> rowMapper = (rs, i) -> mapNotes(rs);
        return jdbcTemplate.query("SELECT u.first_name, u.last_name, u.email, u.phone, n.user_id, n.title, n.note, n.note_priority, n.note_category, n.date_time " +
                "FROM notes n " +
                "LEFT OUTER JOIN users u ON n.user_id = u.id " +
                "WHERE n.user_id = ? ", rowMapper, userId);
    }

    public List<Note> getNotesByPriority(NotePriority prio) {
        RowMapper<Note> rowMapper = (rs, i) -> mapNotes(rs);
        return jdbcTemplate.query("SELECT u.first_name, u.last_name, u.email, u.phone, n.user_id, n.title, n.note, n.note_priority, n.note_category, n.date_time " +
                        "FROM notes n " +
                        "LEFT OUTER JOIN users u ON n.user_id = u.id " +
                        "WHERE n.note_priority::varchar = ? ",
                rowMapper, prio.name());
    }

    private Note mapNotes(ResultSet rs) throws SQLException {

        User user = new User(
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                rs.getString("phone"));

        return new Note(
                rs.getLong("user_id"),
                rs.getString("note"),
                NoteCategory.valueOf(rs.getString("note_category")),
                rs.getObject("date_time", LocalDateTime.class),
                user,
                NotePriority.valueOf(rs.getString("note_priority")),
                rs.getString("title")
        );


        //        note.setId(rs.getLong("id"));
//        note.setTitle(rs.getString("title"));
//        note.setNote(rs.getString("note"));
//        //note.setUser(user);
//        note.setNotePriority(NotePriority.valueOf("note_priority"));
//        note.setCategory(NoteCategory.valueOf("note_category"));
//        //note.setDateTime(rs.getString("date_time"));
    }

    public void storeNotes(Note note) {
        //System.out.println("STORE NOTES: " + note.getUser().getId());
        jdbcTemplate.update("INSERT INTO notes (user_id, title, note, note_category, note_priority, date_time) VALUES (?, ?, ?, ?, ?, ?) ",
                note.getUserId(), note.getTitle(), note.getNote(), note.getCategory().toString(), note.getNotePriority().name(), note.getDateTime());
    }
}
