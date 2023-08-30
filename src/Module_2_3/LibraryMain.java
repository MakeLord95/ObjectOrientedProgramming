package Module_2_3;


import java.util.ArrayList;


class Library {
    private final ArrayList<Book> books = new ArrayList<>();

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


class Book {
    private final String title;
    private final String author;
    private final int publicationYear;

    Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}


public class LibraryMain {
    public static void main(String[] args) {
        Library library = new Library();
        Book lordOfTheRings = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        Book aGameOfThrones = new Book("A Game of Thrones", "George R.R. Martin", 1996);

        library.addBook(lordOfTheRings);
        library.addBook(aGameOfThrones);

        library.displayBooks();

        library.findBooksByAuthor("J.R.R. Tolkien");
    }
}
