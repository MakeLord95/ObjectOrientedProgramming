package Module_6_4.controller;

import Module_6_4.model.Note;
import Module_6_4.model.Notebook;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NotebookController {
    public Button newNoteButton;
    public Button viewNoteButton;
    public Button deleteNoteButton;

    private Note note;
    private final Notebook notebook = new Notebook();

    @FXML
    private TextField noteTitle;

    @FXML
    private TextArea noteContent;

    @FXML
    private ListView<Note> notesDisplay;

    @FXML
    private Button addNoteButton;

    @FXML
    public void addNote() {
        String title = noteTitle.getText();
        String content = noteContent.getText();

        note = new Note();

        note.setNotes(title, content);

        notebook.addNote(note);

        noteTitle.clear();
        noteContent.clear();

        notesDisplay.getItems().clear();
        notesDisplay.getItems().addAll(notebook.getNotes());

    }

    @FXML
    public void viewNote() {
        try {
            note = notesDisplay.getSelectionModel().getSelectedItem();

            String title = note.getTitle();
            String content = note.getNotes();

            noteTitle.setText(title);
            noteContent.setText(content);
        } catch (Exception e) {
            System.out.println("No note selected.");
        }
    }

    @FXML
    public void deleteNote() {
        note = notesDisplay.getSelectionModel().getSelectedItem();

        notebook.deleteNote(note);

        notesDisplay.getItems().remove(note);
    }

    @FXML
    public void newNote() {
        noteTitle.clear();
        noteContent.clear();

        addNoteButton.requestFocus();
    }
}
