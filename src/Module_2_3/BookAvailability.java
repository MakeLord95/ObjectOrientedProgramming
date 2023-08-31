package Module_2_3;


import java.util.ArrayList;


class LibraryBookAvailability {
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

    public void isBookAvailable(String title) {
        boolean foundInLibrary = false;
        boolean foundInBorrowed = false;

        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                foundInLibrary = true;
                break;
            }
        }

        for (Book book : borrowedBooks) {
            if (book.getTitle().equals(title)) {
                foundInBorrowed = true;
                break;
            }
        }

        if (foundInLibrary) {
            System.out.printf("Book %s is available in the library\n", title);
        } else if (foundInBorrowed) {
            System.out.printf("Book %s is borrowed\n", title);
        } else {
            System.out.printf("Book %s is not available\n", title);
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


public class BookAvailability {
    public static void main(String[] args) {
        LibraryBookAvailability libraryBookAvailability = new LibraryBookAvailability();

        Book lordOfTheRings = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        Book aGameOfThrones = new Book("A Game of Thrones", "George R.R. Martin", 1996);

        libraryBookAvailability.addBook(lordOfTheRings);
        libraryBookAvailability.addBook(aGameOfThrones);

        //libraryBookAvailability.displayBooks();

        //libraryBookAvailability.findBooksByAuthor("J.R.R. Tolkien");

        System.out.println("Borrowing book");
        libraryBookAvailability.borrowBooks("A Game of Thrones");

        libraryBookAvailability.displayBooks();

        libraryBookAvailability.isBookAvailable("A Game of Thrones");

        //System.out.printf("Returning book: %s\n", aGameOfThrones.getTitle());
        libraryBookAvailability.returnBook(aGameOfThrones);
        //libraryBookAvailability.displayBooks();

        libraryBookAvailability.isBookAvailable("A Game of Thrones");
        libraryBookAvailability.isBookAvailable("The Witcher");
    }
}
