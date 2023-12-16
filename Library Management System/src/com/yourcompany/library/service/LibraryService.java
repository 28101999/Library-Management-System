// In LibraryService.java
package com.yourcompany.library.service;

import com.yourcompany.library.model.Book;
import com.yourcompany.library.model.User;

import java.time.LocalDate; // Import the LocalDate class for working with dates
import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private Map<Book, User> checkedOutBooks = new HashMap<>();

    public void checkOutBook(User user, Book book) {
        if (!checkedOutBooks.containsKey(book)) {
            LocalDate dueDate = LocalDate.now().plusDays(14); // Set a default due date (14 days from checkout)
            book.setDueDate(dueDate);
            checkedOutBooks.put(book, user);
            System.out.println(user.getName() + " has checked out the book: " + book.getTitle() + " (Due Date: " + dueDate + ")");
        } else {
            System.out.println("Sorry, the book " + book.getTitle() + " is already checked out.");
        }
    }

    public void returnBook(User user, Book book) {
        if (checkedOutBooks.containsKey(book) && checkedOutBooks.get(book).equals(user)) {
            checkedOutBooks.remove(book);
            book.setDueDate(null); // Reset due date when the book is returned
            System.out.println(user.getName() + " has returned the book: " + book.getTitle());
        } else {
            System.out.println("Invalid return. The book " + book.getTitle() + " was not checked out by " + user.getName());
        }
    }
}
