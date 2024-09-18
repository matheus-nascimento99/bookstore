package com.rocketseat.bookstore;

import java.time.LocalDate;

public class Client {
    private int id;
    private String name;
    private LocalDate bornIn;
    private String email;

    public Client(
          int id,
          String name,
          LocalDate bornIn,
          String email
    ) {
        this.id = id;
        this.name = name;
        this.bornIn = bornIn;
        this.email = email;
    }
}
