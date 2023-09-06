package Module_3_3.library.model;

import java.util.ArrayList;

public class LibraryMember {
    private static int nextID;
    private final String name;
    private final int memberID;
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();
    private final ArrayList<Book> reservedBooks = new ArrayList<>();

    public LibraryMember(String name) {
        this.name = name;
        this.memberID = ++nextID;
    }

    public String getName() {
        return name;
    }

    public int getMemberID() {
        return memberID;
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
