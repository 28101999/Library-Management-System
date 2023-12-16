// In Book.java
package com.yourcompany.library.model;

import java.time.LocalDate; // Import the LocalDate class for working with dates

public class Book {
    private int id;
    private String title;
    private String author;
    private LocalDate dueDate; // New field to store due date

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.dueDate = null; // Initialize due date as null
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
