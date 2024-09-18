package com.rocketseat.bookstore;

import java.time.LocalDate;

public class Author {
    private int id;
    private String name;
    private LocalDate bornIn;

    public Author(
            int id,
            String name,
            LocalDate bornIn
    ) {
        this.id = id;
        this.name = name;
        this.bornIn = bornIn;
    }
}
