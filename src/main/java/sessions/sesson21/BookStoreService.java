package sessions.sesson21;

import java.util.List;

public interface BookStoreService {
    void addBookToStore(Book book);
    Book getBookByNumber(int number);
    void deleteBookByNumber(int number);
    int getCountBookByNumber(int number);
    List getBookByAuthor(String author);
    int getCountOfAllBooks();
}
