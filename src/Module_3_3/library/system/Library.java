package Module_3_3.library.system;

import Module_3_3.library.model.Book;
import Module_3_3.library.model.LibraryMember;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<LibraryMember> members = new ArrayList<>();

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
            System.out.printf("Book by the name \"%s\" was added to the library\n", book.getTitle());
        } else {
            System.out.println("Book already exists!");
        }
    }

    public void addMember(LibraryMember libraryMember) {
        if (!members.contains(libraryMember)) {
            members.add(libraryMember);
            System.out.printf("A new member \"%s\" was added to the library\n", libraryMember.getName());
        } else {
            System.out.println("Member already exists!");
        }
    }

    public void borrowBook(LibraryMember libraryMember, Book book) {
        if (books.contains(book) && !book.isReserved()) {
            books.remove(book);
            libraryMember.addBorrowedBook(book);
            System.out.printf("%s borrowed book \"%s\"\n", libraryMember.getName(), book.getTitle());
        } else {
            System.out.println("No book by that name is available!");
        }
    }

    public void returnBook(LibraryMember libraryMember, Book book) {
        if (!books.contains(book) && libraryMember.getBorrowedBooks().contains(book)) {
            libraryMember.removeBorrowedBook(book);
            books.add(book);
            System.out.printf("%s returned book \"%s\"\n", libraryMember.getName(), book.getTitle());
        } else {
            System.out.println("Book by that name isn't borrowed");
        }
    }

    // Task 3 part starts here
    public void reserveBook(LibraryMember libraryMember, Book book) {
        if (!book.isReserved()) {
            book.setReservedStatus(true);
            libraryMember.reserveBook(book);
            System.out.printf("%s reserved book %s\n", libraryMember.getName(), book.getTitle());
        } else {
            System.out.printf("%s is already reserved.\n", libraryMember.getName());
        }
    }

    public void cancelReservation(LibraryMember libraryMember, Book book) {
        if (book.isReserved() && libraryMember.getReservedBooks().contains(book)) {
            book.setReservedStatus(false);
            libraryMember.cancelReservation(book);
            System.out.printf("\"%s\" removed their reservation of \"%s\"\n", libraryMember.getName(), book.getTitle());
        } else {
            System.out.printf("\"%s\" hasn't borrowed book \"%s\"\n", libraryMember.getName(), book.getTitle());
        }
    }

    public void displayReservedBooks(LibraryMember libraryMember) {
        System.out.printf("\"%s\" has currently reserved the following books: \n", libraryMember.getName());

        for (Book book : libraryMember.getReservedBooks()) {
            System.out.printf("\"%s\"\n", book.getTitle());
        }
    }

}
