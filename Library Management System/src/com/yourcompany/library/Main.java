package com.yourcompany.library;

import com.yourcompany.library.model.Book;
import com.yourcompany.library.model.User;
import com.yourcompany.library.service.LibraryService;

public class Main {
    public static void main(String[] args) {
        // Sample usage
        User user = new User(1, "John Doe");
        Book book = new Book(101, "The Great Gatsby", "F. Scott Fitzgerald");

        LibraryService libraryService = new LibraryService();
        libraryService.checkOutBook(user, book);
    }
}
