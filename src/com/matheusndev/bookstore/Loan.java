package com.matheusndev.bookstore;

import java.time.LocalDateTime;
import java.util.UUID;

public class Loan {
    private String id;
    private Book book;
    private Client client;
    private LocalDateTime borrowedIn;
    private LocalDateTime returnedAt;

    public Loan(
            String id,
            Book book,
            Client client
    ) {
        this.id = id;
        this.book = book;
        this.client = client;
        this.borrowedIn = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDateTime getBorrowedIn() {
        return borrowedIn;
    }

    public LocalDateTime getReturnedAt() {
        return returnedAt;
    }

    public void setReturnedAt(LocalDateTime returnedAt) {
        this.returnedAt = returnedAt;
    }
}
