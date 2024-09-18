package com.rocketseat.bookstore;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();

    public List<Book> getAvailableBooks(){
        List<Book> availableBooks = this.books.stream().filter(book -> book.isAvailable()).toList();

        return availableBooks;
    }

    public void createBook(Book book){
        this.books.add(book);
    }

    public void createAuthor(Author author){
        this.authors.add(author);
    }

    public void loan(Loan loan) {
        this.loans.add(loan);
    }
}
