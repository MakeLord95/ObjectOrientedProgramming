package Module_2_3;


import java.util.ArrayList;

class LibraryWithStatistics {
    private final ArrayList<BookWithRating> books = new ArrayList<>();
    private double totalRating;

    public void addBook(BookWithRating book) {
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

    public double getAverageBookRating() {
        int i = 0;
        for (BookWithRating book : books) {
            totalRating += book.getRating();
            i++;
        }
        return totalRating / i;
    }

    public String getMostReviewedBook() {
        if (books.isEmpty()) {
            return null;
        }

        BookWithRating mostReviewedBook = books.get(0);
        int maxReviews = mostReviewedBook.getReviews().size();

        for (int i = 1; i < books.size(); i++) {
            BookWithRating currentBook = books.get(i);
            int currentReviews = currentBook.getReviews().size();

            if (currentReviews > maxReviews) {
                maxReviews = currentReviews;
                mostReviewedBook = currentBook;
            }
        }

        return mostReviewedBook.getTitle();
    }
}


public class LibraryStatistics {
    public static void main(String[] args) {
        LibraryWithStatistics libraryStatistics = new LibraryWithStatistics();
        BookWithRating aGameOfThrones = new BookWithRating("A Game of Thrones", "George R.R. Martin", 1996);
        BookWithRating theLordOfTheRings = new BookWithRating("The Lord of the Rings", "J.R.R. Tolkien", 1954);

        aGameOfThrones.setRating(4.5);
        theLordOfTheRings.setRating(4.9);

        aGameOfThrones.addReview("A good book");
        aGameOfThrones.addReview("I like it a lot");

        theLordOfTheRings.addReview("It's the GOAT!");

        libraryStatistics.addBook(aGameOfThrones);
        libraryStatistics.addBook(theLordOfTheRings);

        double averageRating = libraryStatistics.getAverageBookRating();
        System.out.printf("The average rating of all books in the Library is: %.2f\n", averageRating);

        System.out.printf("The book with the most reviews is: %s\n", libraryStatistics.getMostReviewedBook());
    }
}
