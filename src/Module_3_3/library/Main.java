package Module_3_3.library;

import Module_3_3.library.system.Library;
import Module_3_3.library.model.*;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        LibraryMember libraryMember_Matti = new LibraryMember("Matti");
        LibraryMember libraryMember_Mikko = new LibraryMember("Mikko");

        Book lordOfTheRings = new Book("The Lord of the Rings", "J.R.R. Tolkien", "12345");
        Book aGameOfThrones = new Book("A Game of Thrones", "George R.R. Martin", "54321");

        library.addBook(aGameOfThrones);
        library.addBook(lordOfTheRings);

        library.addMember(libraryMember_Matti);
        library.addMember(libraryMember_Mikko);

        library.borrowBook(libraryMember_Matti, aGameOfThrones);
        library.borrowBook(libraryMember_Mikko, lordOfTheRings);

        library.returnBook(libraryMember_Matti, aGameOfThrones);
        library.returnBook(libraryMember_Mikko, lordOfTheRings);

        // Task 3 part starts here
        library.reserveBook(libraryMember_Matti, aGameOfThrones);
        library.reserveBook(libraryMember_Mikko, lordOfTheRings);

        library.displayReservedBooks(libraryMember_Matti);
        library.displayReservedBooks(libraryMember_Mikko);

        library.cancelReservation(libraryMember_Matti, aGameOfThrones);
        library.cancelReservation(libraryMember_Mikko, lordOfTheRings);
    }
}
