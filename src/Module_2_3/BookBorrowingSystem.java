package Module_2_3;


import java.util.ArrayList;


class LibraryBorrow extends Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    void borrowBooks(String title) {
        for (Book book : books) {
            // WIP
        }
    }
}


public class BookBorrowingSystem {
    public static void main(String[] args) {
        LibraryBorrow libraryBorrow = new LibraryBorrow();

        Book lordOfTheRings = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        Book aGameOfThrones = new Book("A Game of Thrones", "George R.R. Martin", 1996);

        libraryBorrow.addBook(lordOfTheRings);
        libraryBorrow.addBook(aGameOfThrones);

        libraryBorrow.displayBooks();

        libraryBorrow.findBooksByAuthor("J.R.R. Tolkien");
        libraryBorrow.borrowBooks("A Game of Thrones");

        libraryBorrow.displayBooks();
    }
}
