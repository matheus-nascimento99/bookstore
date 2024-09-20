package com.matheusndev.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Library {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private List<Loan> loans = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public List<Book> getAvailableBooks(){
        List<Book> availableBooks = this.books.stream().filter(book -> book.isAvailable()).toList();

        return availableBooks;
    }

    public List<Book> getUnavailableBooks(){
        List<Book> availableBooks = this.books.stream().filter(book -> !book.isAvailable()).toList();

        return availableBooks;
    }

    public List<Client> getClients() {
        return clients;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public Optional<Book> findBookById(UUID id) {
        Optional<Book> bookById = this.books.stream().filter(book -> book.getId().equals(id)).findFirst();

        return bookById;
    }

    public void createBook(Book book){
        this.books.add(book);
    }

    public void saveBook(UUID id, Book book){
        Book bookById = this.books.stream().filter(currentBook -> currentBook.getId().equals(id)).findFirst().get();
        int bookIndex = this.books.indexOf(bookById);

        this.books.set(bookIndex, book);
    }

    public void createAuthor(Author author){
        this.authors.add(author);
    }

    public void createClient(Client client){
        this.clients.add(client);
    }

    public Optional<Client> findClientById(UUID id) {
        Optional<Client> clientById = this.clients.stream().filter(client -> client.getId().equals(id)).findFirst();

        return clientById;
    }

    public void loan(Loan loan) {
        this.loans.add(loan);
    }

    public Optional<Loan> findLoanById(UUID id) {
        Optional<Loan> loanById = this.loans.stream().filter(loan -> loan.getId().equals(id)).findFirst();

        return loanById;
    }

    public void saveLoan(UUID id, Loan loan){
        Loan loanById = this.loans.stream().filter(currentBook -> currentBook.getId().equals(id)).findFirst().get();
        int loanIndex = this.loans.indexOf(loanById);

        this.loans.set(loanIndex, loan);
    }
}
