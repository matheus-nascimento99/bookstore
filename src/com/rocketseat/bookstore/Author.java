package com.rocketseat.bookstore;

import java.time.LocalDate;
import java.util.UUID;

public class Author {
    private UUID id;
    private String name;
    private LocalDate bornIn;

    public Author(
            String name,
            LocalDate bornIn
    ) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.bornIn = bornIn;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getBornIn() {
        return bornIn;
    }

    public void setBornIn(LocalDate bornIn) {
        this.bornIn = bornIn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
