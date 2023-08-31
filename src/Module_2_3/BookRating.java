package Module_2_3;


import java.util.ArrayList;


class BookWithRating extends Book {
    private final ArrayList<String> reviews = new ArrayList<>();
    private double rating = 0.0;

    BookWithRating(String title, String author, int publicationYear) {
        super(title, author, publicationYear);
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    public void setRating(double rating) {
        if (rating >= 0.0 && rating <= 5.0) {
            this.rating = rating;
        }
    }

    public double getRating() {
        return rating;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }
}


public class BookRating {
    public static void main(String[] args) {
        BookWithRating book = new BookWithRating("A Game of Thrones", "George R.R. Martin", 1996);

        book.addReview("A good book.");
        book.setRating(4.5);

    }
}
