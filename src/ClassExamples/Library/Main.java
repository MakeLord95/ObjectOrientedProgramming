package ClassExamples.Library;

import ClassExamples.Library.System.Book;
import ClassExamples.Library.System.Library;
import ClassExamples.Library.System.User;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book theLordOfTheRings = new Book("The Lord of the Rings", "J.R.R. Tolkien", 1954);
        library.addBook(theLordOfTheRings);

        Book theHobbit = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook(theHobbit);

        Book theSilmarillion = new Book("The Silmarillion", "J.R.R. Tolkien", 1977);
        library.addBook(theSilmarillion);

        User john = new User("John");
        library.addUser(john);

        User jane = new User("Jane");
        library.addUser(jane);

        library.borrowBook(theLordOfTheRings, john);
        library.borrowBook(theHobbit, jane);

        library.returnBook(theLordOfTheRings, john);
        library.returnBook(theHobbit, jane);
        library.returnBook(theSilmarillion, jane);

        System.out.println(library);
        library.getBooks();
        library.getUsers();
    }
}
