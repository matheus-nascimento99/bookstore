package com.matheusndev.bookstore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Entrypoint {
    static boolean online = true;
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args){
        library.createBook(new Book("book-01", "book-title", new Author("author-01", LocalDate.of(1999, 9, 30))));

        System.out.println("===== Welcome to World of Words! =====");

        do {
            menu();
        } while (online);

        System.out.println("===== Thanks for trust in World of Words, See you! =====");
        scanner.close();
    }

    public static void menu(){
        System.out.println("Choose an option:");
        System.out.println("1 - List books available to loan");
        System.out.println("2 - List books unavailable to loan");
        System.out.println("3 - List clients");
        System.out.println("4 - List loans");
        System.out.println("5 - Register new book");
        System.out.println("6 - Register new client");
        System.out.println("7 - Register new loan");
        System.out.println("8 - Return book");
        System.out.println("9 - List loan history");
        System.out.println("10 - Logout");

        try {
            int option = scanner.nextInt();

            switch (option){
                case 1:
                    listAvailableBooks();
                    break;
                case 2:
                    listUnavailableBooks();
                    break;
                case 3:
                    listClients();
                    break;
                case 4:
                    listLoans();
                    break;
                case 5:
                    registerNewBook();
                    break;
                case 6:
                    registerNewClient();
                    break;
                case 7:
                    registerNewLoan();
                    break;
                case 8:
                    returnBook();
                    break;
                case 9:
                    listLoansHistory();
                    break;
                case 10:
                    logout();
                    break;
                default:
                    System.out.println("Unknown option!");
            }
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Choose a valid option!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void listAvailableBooks(){
        List<Book> books = library.getAvailableBooks();

        if(books.size() > 0){
            books.forEach(book -> {
                StringBuilder bookInformations = new StringBuilder();

                bookInformations.append(String.format("ID: %s", book.getId()));
                bookInformations.append(String.format(" TITLE: %s", book.getTitle()));

                System.out.println(bookInformations);
            });


        } else {
            System.out.println("No one found...");
        }

    }

    public static void listUnavailableBooks(){
        List<Book> books = library.getUnavailableBooks();

        if(books.size() > 0){
            books.forEach(book -> {
                StringBuilder bookInformations = new StringBuilder();

                bookInformations.append(String.format("ID: %s", book.getId()));
                bookInformations.append(String.format(" TITLE: %s", book.getTitle()));

                System.out.println(bookInformations);
            });
        } else {
            System.out.println("No one found...");
        }

    }

    public static void listClients(){
        List<Client> clients = library.getClients();

        if(clients.size() > 0){
            clients.forEach(client -> {
                StringBuilder clientInformations = new StringBuilder();

                clientInformations.append(String.format("ID: %s", client.getId()));
                clientInformations.append(String.format(" NAME: %s", client.getName()));
                clientInformations.append(String.format(" EMAIL: %s", client.getEmail()));

                System.out.println(clientInformations);
            });
        } else {
            System.out.println("No one found...");
        }
    }

    public static void listLoans(){
        List<Loan> loans = library.getLoans();

        if(loans.size() > 0){
            loans.forEach(loan -> {
                StringBuilder loanInformations = new StringBuilder();

                loanInformations.append(String.format("ID: %s", loan.getId()));
                loanInformations.append(String.format(" CLIENT: %s", loan.getClient().getName()));
                loanInformations.append(String.format(" BOOK: %s", loan.getBook().getTitle()));

                System.out.println(loanInformations);
            });
        } else {
            System.out.println("No one found...");
        }
    }

    public static void registerNewBook() {}

    public static void registerNewClient() {}

    public static void registerNewLoan() {}

    public static void returnBook() {}

    public static void listLoansHistory() {}

    public static void logout() {
        online = false;
    }
}