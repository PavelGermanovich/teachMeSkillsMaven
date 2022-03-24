package sessions.session21;

import java.util.ArrayList;

public interface BookStoreService {
    void addBookToStore(Book book);
    Book getBookByNumber(int number);
    void deleteBookByNumber(int number);
    int getCountBookByNumber(int number);
    ArrayList<Book> getBookByAuthor(String author);
    int getCountOfAllBooks();
}
