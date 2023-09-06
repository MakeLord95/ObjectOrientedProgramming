package Module_3_3.library.model;

import java.util.ArrayList;

public class LibraryMember {
    private final String name;
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();
    private final ArrayList<Book> reservedBooks = new ArrayList<>();
    private int memberID;

    public LibraryMember(String name) {
        this.name = name;
        ++this.memberID;
    }

    public String getName() {
        return name;
    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    public void removeBorrowedBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Task 3 part starts here
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void reserveBook(Book book) {
        reservedBooks.add(book);
    }

    public void cancelReservation(Book book) {
        reservedBooks.remove(book);
    }

    public ArrayList<Book> getReservedBooks() {
        return reservedBooks;
    }
}
