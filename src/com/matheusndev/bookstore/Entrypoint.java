package com.matheusndev.bookstore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Entrypoint {
    static boolean online = true;
    static Scanner scanner = new Scanner(System.in);
    static Library library = new Library();

    public static void main(String[] args){

        System.out.println("===== Welcome to World of Words! =====");

        do {
            menu();
        } while (online);

        System.out.println("===== Thanks for trust in World of Words, See you! =====");
        scanner.close();
    }

    public static void menu(){
        System.out.println("Choose an option:");
        System.out.println("1 - List available books to loan");
        System.out.println("2 - List unavailable books to loan");
        System.out.println("3 - List clients");
        System.out.println("4 - List loans");
        System.out.println("5 - Register new book");
        System.out.println("6 - Register new client");
        System.out.println("7 - Register new loan");
        System.out.println("8 - Return book");
        System.out.println("9 - Logout");

        try {
            int option = scanner.nextInt();
            scanner.nextLine();

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

    public static void registerNewBook() {

        String title;
        do {
            System.out.println("Type book title please");
            title = scanner.nextLine();

            if(title.isBlank()){
                System.out.println("Book title cannot be empty, try again!");
            }
        } while (title.isBlank());


        String authorName;
        do {
            System.out.println("Type author name please");
            authorName = scanner.nextLine();

            if(authorName.isBlank()){
                System.out.println("Author name cannot be empty, try again!");
            }
        } while (authorName.isBlank());

        String birthStringDate;
        LocalDate birthDate = null;

        do {
            System.out.println("Type author date of birth please (eg: 10/10/2022)");
            birthStringDate = scanner.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                birthDate = LocalDate.parse(birthStringDate, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date, try again!");
                birthStringDate = "";
            }

        } while (birthStringDate.isBlank() || birthDate == null);

        Author author = new Author(authorName, birthDate);
        Book book = new Book(title, author);

        library.createBook(book);

        System.out.println("Book successfully created!");
    }

    public static void registerNewClient() {
        String name;
        do {
            System.out.println("Type client name please");
            name = scanner.nextLine();

            if(name.isBlank()){
                System.out.println("Client name cannot be empty, try again!");
            }
        } while (name.isBlank());


        String email;
        do {
            System.out.println("Type author email please");
            email = scanner.nextLine();

            if(email.isBlank()){
                System.out.println("Author email cannot be empty, try again!");
            }
        } while (email.isBlank());

        String birthStringDate;
        LocalDate birthDate = null;

        do {
            System.out.println("Type client date of birth please (eg: 10/10/2022)");
            birthStringDate = scanner.nextLine();

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                birthDate = LocalDate.parse(birthStringDate, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date, try again!");
                birthStringDate = "";
            }

        } while (birthStringDate.isBlank() || birthDate == null);

        Client client = new Client(name, birthDate, email);

        library.createClient(client);

        System.out.println("Client successfully created!");
    }

    public static void registerNewLoan() {
        String bookId;
        Book book = null;
        do {
            System.out.println("Type book id please");
            bookId = scanner.nextLine();

            if(bookId.isBlank()){
                System.out.println("Book id cannot be empty, try again!");
                continue;
            }

            UUID bookUUID;

            try {
                bookUUID = UUID.fromString(bookId);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid id.");
                continue;
            }

            Optional<Book> bookOpt = library.findBookById(bookUUID);

            if(!bookOpt.isPresent()){
                System.out.println("Book not found.");
                continue;
            }

            book = bookOpt.get();
            book.setAvailable(false);

            library.saveBook(book.getId(), book);
        } while (bookId.isBlank() || book == null);

        String clientId;
        Client client = null;
        do {
            System.out.println("Type client id please");
            clientId = scanner.nextLine();

            if(clientId.isBlank()){
                System.out.println("Client id cannot be empty, try again!");
                continue;
            }

            UUID clientUUID;

            try {
                clientUUID = UUID.fromString(clientId);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid id.");
                continue;
            }

            Optional<Client> clientOpt = library.findClientById(clientUUID);

            if(!clientOpt.isPresent()){
                System.out.println("Client not found.");
                continue;
            }

            client = clientOpt.get();

        } while (clientId.isBlank() || client == null);

        Loan loan = new Loan(book, client);

        library.loan(loan);

        System.out.println("Loan successfully created!");
    }

    public static void returnBook() {
        String loanId;
        Loan loan = null;
        do {
            System.out.println("Type loan id please");
            loanId = scanner.nextLine();

            if(loanId.isBlank()){
                System.out.println("Loan id cannot be empty, try again!");
                continue;
            }

            UUID loanUUID;

            try {
                loanUUID = UUID.fromString(loanId);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid id.");
                continue;
            }

            Optional<Loan> loanOpt = library.findLoanById(loanUUID);

            if(!loanOpt.isPresent()){
                System.out.println("Loan not found.");
                continue;
            }

            loan = loanOpt.get();


        } while (loanId.isBlank() || loan == null);

        loan.getBook().setAvailable(true);

        library.saveBook(loan.getBook().getId(), loan.getBook());

        loan.setReturnedAt(LocalDateTime.now());

        library.saveLoan(loan.getId(), loan);

        System.out.println("Book successfully returned!");
    }

    public static void logout() {
        online = false;
    }
}