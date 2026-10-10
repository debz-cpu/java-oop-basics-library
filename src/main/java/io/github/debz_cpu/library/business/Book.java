package io.github.debz_cpu.library.business;

import java.time.Year;

public class Book {

    // Books before the printing press are out of scope for this library
    private static final int EARLIEST_PUBLICATION_YEAR = 1440;

    private final String title;
    private final String author;
    private final String isbn;
    private final int publicationYear;

    public Book(String title, String author, String isbn, int publicationYear) {
        this.title = requireNonBlank(title, "title");
        this.author = requireNonBlank(author, "author");
        this.isbn = requireNonBlank(isbn, "isbn");

        int currentYear = Year.now().getValue();
        if (publicationYear < EARLIEST_PUBLICATION_YEAR || publicationYear > currentYear) {
            throw new IllegalArgumentException(
                    "Publication year " + publicationYear + " is invalid. Must be between "
                            + EARLIEST_PUBLICATION_YEAR + " and " + currentYear + ".");
        }
        this.publicationYear = publicationYear;
    }

    private static String requireNonBlank(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " must not be empty");
        }
        return value;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return "Book{title='" + title + "', author='" + author + "', isbn='" + isbn
                + "', publicationYear=" + publicationYear + "}";
    }
}