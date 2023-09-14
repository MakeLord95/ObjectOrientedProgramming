This is a simple class that represents a book. It has three fields: title, author, and publication year. It has a constructor that takes values for each of these fields. It has getters for each of these fields. It has a toString method that returns a string representation of the book.
```java
package ClassExamples.Library.System;

public class Book {
    private final String title;
    private final String author;
    private final int publicationYear;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public String toString() {
        return String.format("%s by %s (%d)", title, author, publicationYear);
    }

}

```