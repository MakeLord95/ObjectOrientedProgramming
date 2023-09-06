package Module_3_3.library;

import Module_3_3.library.system.Library;
import Module_3_3.library.model.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryMember matti = new LibraryMember("Matti");
        LibraryMember mikko = new LibraryMember("Mikko");

        Book lordOfTheRings = new Book("The Lord of the Rings", "J.R.R. Tolkien", "12345");
        Book aGameOfThrones = new Book("A Game of Thrones", "George R.R. Martin", "54321");

        library.addBook(aGameOfThrones);
        library.addBook(lordOfTheRings);

        library.addMember(matti);
        library.addMember(mikko);

        library.borrowBook(matti, aGameOfThrones);
        library.borrowBook(mikko, lordOfTheRings);

        library.returnBook(matti, aGameOfThrones);
        library.returnBook(mikko, lordOfTheRings);

        // Task 3 part starts here
        library.reserveBook(matti, aGameOfThrones);
        library.reserveBook(mikko, lordOfTheRings);

        library.displayReservedBooks(matti);
        library.displayReservedBooks(mikko);

        library.cancelReservation(matti, aGameOfThrones);
        library.cancelReservation(mikko, lordOfTheRings);
    }
}
