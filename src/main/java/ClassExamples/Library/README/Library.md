This java class represents a library. It has three fields: books, users, and borrowed books. It has a constructor that takes no arguments. It has methods to add books and users to the library. It has methods to get the books, users, and borrowed books. It has a toString method that returns a string representation of the library. It has methods to borrow and return books.
```java
package ClassExamples.Library.System;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Book> books = new ArrayList<>();
    private final ArrayList<User> users = new ArrayList<>();
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void getBooks() {
        for (Book book : books) {
            System.out.printf("%s by %s (%d)%n", book.getTitle(), book.getAuthor(), book.getPublicationYear());
        }
    }

    public void getUsers() {
        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    public void getBorrowedBooks() {
        for (Book book : borrowedBooks) {
            System.out.println(book.getTitle());
        }
    }

    public String toString() {
        return String.format("Library with %d books and %d users", books.size(), users.size());
    }

    public void borrowBook(Book book, User user) {
        if (books.contains(book) && users.contains(user)) {
            books.remove(book);
            borrowedBooks.add(book);
        }
    }

    public void returnBook(Book book, User user) {
        if (borrowedBooks.contains(book) && users.contains(user)) {
            borrowedBooks.remove(book);
            books.add(book);
        }
    }
}

```