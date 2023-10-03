package Module_2_3;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class LibraryWithUsers {
    private final ArrayList<Book> books = new ArrayList<>();
    private final Map<User, List<Book>> userBooks = new HashMap<>();

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

    public void registerUser(User user) {
        if (!userBooks.containsKey(user)) {
            userBooks.put(user, new ArrayList<>());
        }
    }

    public void borrowBook(User user, Book book) {
        if (userBooks.containsKey(user)) {
            userBooks.get(user).add(book);
            System.out.printf("%s has borrowed \"%s\"\n", user.getName(), book.getTitle());
        }
    }

    public void displayUserBooks(User user) {
        if (userBooks.containsKey(user)) {
            List<Book> borrowedBooks = userBooks.get(user);
            System.out.printf("%s's Borrowed Books:\n", user.getName());

            for (Book book : borrowedBooks) {
                System.out.printf("Title: \"%s\", Author: \"%s\", Year: %d\n", book.getTitle(), book.getAuthor(), book.getPublicationYear());
            }
        }
    }
}


class User {
    private final String name;
    private final int age;
    private final ArrayList<Book> borrowedBooks = new ArrayList<>();

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
}


public class LibraryUsers {
    public static void main(String[] args) {
        LibraryWithUsers library = new LibraryWithUsers();

        Book lordOfTheRings = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        Book aGameOfThrones = new Book("A Game of Thrones", "George R.R. Martin", 1996);

        User userA = new User("User A", 25);
        User userB = new User("User B", 30);

        library.addBook(lordOfTheRings);
        library.addBook(aGameOfThrones);

        library.registerUser(userA);
        library.registerUser(userB);

        library.borrowBook(userA, aGameOfThrones);
        library.borrowBook(userA, lordOfTheRings);

        library.displayBooks();

        library.findBooksByAuthor("J.R.R. Tolkien");
    }
}
