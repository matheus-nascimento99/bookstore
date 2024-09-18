package com.rocketseat.bookstore;

import java.time.LocalDateTime;

public class Book {
    private int id;
    private String title;
    private Author author;
    private boolean isAvailable;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Book(
                int id,
                String title,
                Author author,
                boolean isAvailable
            ) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
