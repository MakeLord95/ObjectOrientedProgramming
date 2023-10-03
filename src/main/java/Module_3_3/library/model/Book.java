package Module_3_3.library.model;

public class Book {
    private final String title;
    private final String author;
    private final String isbn;
    private boolean reserved = false;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    // Task 3 part starts here
    public boolean isReserved() {
        return reserved;
    }

    public void setReservedStatus(boolean reserved) {
        this.reserved = reserved;
    }
}
