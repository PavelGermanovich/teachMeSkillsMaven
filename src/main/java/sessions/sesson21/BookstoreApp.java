package sessions.sesson21;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class BookstoreApp {
    private BookstoreHandlerMysql bookstoreHandler = new BookstoreHandlerMysql();
    private Scanner scanner = new Scanner(System.in);

    public void startApp() {
        int i;
        do {
            i = selectOption();
        } while (i != 7);
    }

    private int selectOption() {
        out.println("Welcome to the bookstore application here the options:" +
                "\n1) Add book \n2) Get book by number \n3) Delete book by number " +
                "\n4) Get count by number \n5) Get by author \n6) get count all books \n7) Exit");
        int option = validateInputNumber();
        if (option == 1) {
            addBook();
        } else if (option == 2) {
            getBookByNumber();
        } else if (option == 3) {
            deleteBookByNumber();
        } else if (option == 4) {
            getCountByNumber();
        } else if (option == 5) {
            getByAuthor();
        } else if (option == 6) {
            getAllBooks();
        } else if (option == 7){
            return option;
        } else {
            out.println("Incorrect option selected!");
            return option;
        }
        return option;
    }

    private void addBook() {
        Book bookToAdd = new Book();
        do {
            Scanner scanner = new Scanner(System.in);
            out.println("Input book info for adding");
            out.println("Input book name");
            bookToAdd.setName(scanner.nextLine());
            out.println("Input book number");
            bookToAdd.setNumber(validateInputNumber());
            out.println("Input author");
            bookToAdd.setAuthor(scanner.nextLine());
            out.println("Input book count");
            bookToAdd.setCount(validateInputNumber());
        } while (!bookstoreHandler.isBookValid(bookToAdd));
        bookstoreHandler.addBookToStore(bookToAdd);
        out.println(bookToAdd);
    }

    private void getBookByNumber() {
        out.println("Input book number");
        int bookNumber = validateInputNumber();
        if (bookstoreHandler.isBookExistInStore(bookNumber)) {
            Book book = bookstoreHandler.getBookByNumber(bookNumber);
            out.println("Book was returned:\n" + book);
        } else {
            out.println("There is no book with such number in the store!");
        }
    }

    private void deleteBookByNumber() {
        out.println("Input number of the book to delete");
        int bookNumber = validateInputNumber();
        if (bookstoreHandler.isBookExistInStore(bookNumber)) {
            if (bookstoreHandler.isBookCountNotZero(bookNumber)) {
                bookstoreHandler.deleteBookByNumber(bookNumber);
            } else {
                out.println("Such book exist in store, but count less than 1");
            }
        } else {
            out.println("Book with number does not exist in the store!");
        }
    }

    private void getCountByNumber() {
        out.println("Input book number");
        int count = bookstoreHandler.getCountBookByNumber(validateInputNumber());
        if (count >= 0) {
            out.println("count of such books is " + count);
        } else {
            out.println("Book with number does not exist in the store!");
        }
    }

    private void getByAuthor() {
        out.println("Input author name");
        String author = scanner.nextLine();
        if (bookstoreHandler.isBookWithSuchAuthorExist(author)) {
            ArrayList books = bookstoreHandler.getBookByAuthor(author);
            books.forEach(out::print);
        } else {
            out.println("There is no book with such author in store!");
        }
    }

    private void getAllBooks() {
        out.println("All books count is " + bookstoreHandler.getCountOfAllBooks());
    }

    private int validateInputNumber() {
        int result = -1;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                result = scanner.nextInt();
            } catch (InputMismatchException e) {
                out.println("Incorrect symbol, please input digit");
            }
        } while (result == -1);
        return result;
    }
}
