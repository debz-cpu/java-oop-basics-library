package io.github.debz_cpu.library;

import io.github.debz_cpu.library.business.Book;

public class Main {
    public static void main(String[] args) {
        System.out.println("Library started");

        Book book = new Book("Effective Java", "Joshua Bloch", "978-0134685991", 2018);
        System.out.println(book);

        // Manual checks of the Book rules; these become JUnit tests in issue #19
        try {
            new Book("   ", "Joshua Bloch", "978-0134685991", 2018);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        try {
            new Book("Future Coding", "John Doe", "111-222-333", 2030);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }

        try {
            new Book("Ancient Scrolls", "Unknown", "000-000-000", 1200);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: " + e.getMessage());
        }
    }
}