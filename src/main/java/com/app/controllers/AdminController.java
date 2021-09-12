package com.app.controllers;

import com.app.model.Note;
import com.app.model.enums.NoteCategory;
import com.app.model.enums.NotePriority;
import com.app.services.AdminService;
import com.app.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("_admin/panel")
    public String getAdminPanel(Model model) {
        return "admin/adminpanel";
    }

    @GetMapping("_admin/allusers")
    public String getAllUsers(Model model) {
        model.addAttribute("userData", adminService.getUsers());
        return "admin/allusers";
    }

    @GetMapping("_admin/allnotes")
    public String getAllNotes(Model model) {
        model.addAttribute("noteData", adminService.getNotes());
        return "admin/allnotes";
    }

    @GetMapping("_admin/new_note")
    public String getCreationPageForNotes(Model model) {
        model.addAttribute("noteData", new Note());  // new Note
        model.addAttribute("userData", adminService.getUsers());
        model.addAttribute("catData", NoteCategory.values()); // Category selection
        model.addAttribute("priorData", NotePriority.values()); // Priority selection

        return "admin/newnote";
    }

    @Autowired
    private NoteService noteService;

    @PostMapping("_admin/new_note")
    public String newNoteForUser(@ModelAttribute Note newNote) {

        if (noteService.validateNote(newNote) == null ) {
            return "redirect:/new_note";
        }
        adminService.storeNote(newNote);
        return "redirect:/_admin/allnotes";
    }

    @GetMapping("_admin/categories")
    public String getCategories(Model model) {

        model.addAttribute("catData", NoteCategory.values()); // Category selection

        return "admin/showCategories";
    }

    @GetMapping("_admin/priorities")
    public String getPriorities(Model model) {

        model.addAttribute("priorData", NotePriority.values()); // Priority selection

        return "admin/showPriorities";
    }

    // Show notes only from one user
    @GetMapping("_admin/user_notes/{id}")
    public String getAllUsersNotesPage(@PathVariable(value = "id") long id, Model model) {
        System.out.println("1) LOADING USER NOTES");

        model.addAttribute("noteData", adminService.getUserNotes(id));
        System.out.println("Notes from db: " + adminService.getUserNotes(id));

        System.out.println("2) PAGE LOADED");
        return "admin/allnotes";

    }

    @GetMapping("_admin/notes/by_priority/{prio}")
    public String getNotesByPriorityPage(@PathVariable(name = "prio") String prio, Model model) {
        System.out.println("1) LOADING USER NOTES");

        NotePriority notePriority = NotePriority.valueOf(prio);
        System.out.println("Notes from db: " + adminService.getNotesByPriority(notePriority));
        model.addAttribute("noteData", adminService.getNotesByPriority(notePriority));


        System.out.println("2) PAGE LOADED");
        return "admin/allnotes";

    }

    @GetMapping("_admin/notes/by_category/{cat}")
    public String getNotesByCategoryPage(@PathVariable(name = "cat") String cat, Model model) {
        System.out.println("1) LOADING USER NOTES");

        NoteCategory noteCategory = NoteCategory.valueOf(cat);
        System.out.println("Notes from db: " + adminService.getNotesByCategory(noteCategory));
        model.addAttribute("noteData", adminService.getNotesByCategory(noteCategory));


        System.out.println("2) PAGE LOADED");
        return "admin/allnotes";

    }
}
