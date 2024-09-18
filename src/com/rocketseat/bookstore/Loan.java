package com.rocketseat.bookstore;

import java.time.LocalDateTime;

public class Loan {
    private int id;
    private Book book;
    private Client client;
    private LocalDateTime borrowedIn;
    private LocalDateTime returnedAt;

    public Loan(
            int id,
            Book book,
            Client client
    ) {
        this.id = id;
        this.book = book;
        this.client = client;
        this.borrowedIn = LocalDateTime.now();
    }
}
