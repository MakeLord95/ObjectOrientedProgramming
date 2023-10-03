package Module_2_3;


import java.util.ArrayList;


class LibraryBorrow {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    void borrowBooks(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                books.remove(book);
                borrowedBooks.add(book);

                break;
            }
        }
    }

    public void returnBook(Book book) {
        for (Book book1 : borrowedBooks) {
            if (book == book1) {
                borrowedBooks.remove(book1);
                books.add(book1);

                break;
            }
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayBooks() {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.printf("%d. Title: \"%s\", Author: \"%s\", Year: %d\n", i + 1, book.getTitle(), book.getAuthor(), book.getPublicationYear());
        }
    }

    public void findBooksByAuthor(String author) {
        for (Book book : books) {
            String bookAuthor = book.getAuthor();

            if (author.equals(bookAuthor)) {
                System.out.printf("Books by Author \"%s\":\n", bookAuthor);
                System.out.printf("Title: \"%s\", Year: %d\n", book.getTitle(), book.getPublicationYear());
            }
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

        System.out.println("Borrowing book");
        libraryBorrow.borrowBooks("A Game of Thrones");

        libraryBorrow.displayBooks();

        System.out.printf("Returning book: %s\n", aGameOfThrones.getTitle());
        libraryBorrow.returnBook(aGameOfThrones);
        libraryBorrow.displayBooks();
    }
}
