package com.matheusndev.bookstore;

import java.time.LocalDate;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;
    private LocalDate bornIn;
    private String email;

    public Client(
          String name,
          LocalDate bornIn,
          String email
    ) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.bornIn = bornIn;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBornIn() {
        return bornIn;
    }

    public void setBornIn(LocalDate bornIn) {
        this.bornIn = bornIn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
