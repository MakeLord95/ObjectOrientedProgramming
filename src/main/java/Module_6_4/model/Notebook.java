package Module_6_4.model;

import java.util.ArrayList;

public class Notebook {
    private final ArrayList<Note> notes = new ArrayList<>();

    public Notebook() {
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void deleteNote(Note note) {
        notes.remove(note);
    }

    public ArrayList<Note> getNotes() {
        return notes;
    }
}
