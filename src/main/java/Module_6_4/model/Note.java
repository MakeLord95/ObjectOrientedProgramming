package Module_6_4.model;

public class Note {
    private String title;
    private String notes;

    public Note() {
    }

    public String getTitle() {
        return title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String title, String notes) {
        this.title = title;
        this.notes = notes;
    }

    @Override
    public String toString() {
        return String.format("%s", title);
    }
}
