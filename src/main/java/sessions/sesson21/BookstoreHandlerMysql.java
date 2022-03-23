package sessions.sesson21;

import homework.lesson20.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookstoreHandlerMysql implements BookStoreService {

    public boolean isBookValid(Book book) {
        if (isBookExistInStore(book.getNumber())) {
            Book bookFromDb = getBookByNumber(book.getNumber());
            if (bookFromDb.equals(book)) {
                return true;
            } else {
                System.out.println("Input book number exists in DB but existing book has different parameters!" +
                        " Please correct!");
                return false;
            }
        } else {
            return true;
        }
    }

    public void addBookToStore(Book book) {
        if (isBookExistInStore(book.getNumber())) {
            increaseBookCount(book);
        } else {
            String insertQuery = String.format("insert into bookstore (name, number, author, count) " +
                            "values('%s', %d, '%s', %d)",
                    book.getName(), book.getNumber(), book.getAuthor(), book.getCount());
            if (DbUtils.executeUpdate(insertQuery) > 0) {
                System.out.println("New book added!");
            } else {
                System.out.println("Book was not added");
            }
        }
    }

    public boolean isBookExistInStore(int number) {
        String selectBook = String.format("Select * from bookstore where number = '%s'", number);
        ResultSet rs = DbUtils.doRequest(selectBook);
        try {
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean isBookCountNotZero(int number) {
        String selectBook = String.format("Select * from bookstore where number = '%s' and count > 0", number);
        ResultSet rs = DbUtils.doRequest(selectBook);
        try {
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void increaseBookCount(Book book) {
        String increaseBook = String.format("update bookstore set count = count + %d where number = %d",
                book.getCount(), book.getNumber());
        if (DbUtils.executeUpdate(increaseBook) > 0) {
            System.out.println("Book count was increased as the book existed in DB");
        } else {
            System.out.println("book count was not updated!");
        }
    }

    public Book getBookByNumber(int number) {
        String selectByNumber = String.format("Select * from bookstore where number = '%d'", number);
        ResultSet rs = DbUtils.doRequest(selectByNumber);
        Book bookFromDb = new Book();
        try {
            if (rs.next()) {
                bookFromDb.setId(rs.getInt("id"));
                bookFromDb.setName(rs.getString("name"));
                bookFromDb.setNumber(rs.getInt("number"));
                bookFromDb.setAuthor(rs.getString("author"));
                bookFromDb.setCount(rs.getInt("count"));
            } else {
                System.out.println("There is no such book in DB!!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return bookFromDb;
    }

    public void deleteBookByNumber(int number) {
        String decreaseBookCount = String.format("update bookstore set count = count - 1 where number = %d", number);
        if (DbUtils.executeUpdate(decreaseBookCount) > 0) {
            System.out.println("Book number was decreased by one");
        } else {
            System.out.println("update failed");
        }
    }

    public int getCountBookByNumber(int number) {
        String getCount = String.format("Select count from bookstore where number = %d", number);
        ResultSet rs = DbUtils.doRequest(getCount);
        try {
            if (rs.next()) {
                int count = rs.getInt("count");
                System.out.println("Count of the book was extracted");
                return count;
            } else {
                System.out.println("There is not such book");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }

    public List getBookByAuthor(String author) {
        String query = String.format("Select * from bookstore where author like '%s'", author);
        ResultSet rs = DbUtils.doRequest(query);
        List<Book> books = new ArrayList<>();
        try {
            while (rs.next()) {
                Book bookFromDb = new Book();
                bookFromDb.setId(rs.getInt("id"));
                bookFromDb.setName(rs.getString("name"));
                bookFromDb.setNumber(rs.getInt("number"));
                bookFromDb.setAuthor(rs.getString("author"));
                bookFromDb.setCount(rs.getInt("count"));
                books.add(bookFromDb);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("books extracted from DB");
        return books;
    }

    public boolean isBookWithSuchAuthorExist(String author) {
        String query = String.format("Select * from bookstore where author like '%s'", author);
        ResultSet rs = DbUtils.doRequest(query);
        try {
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int getCountOfAllBooks() {
        String countSelect = "select sum(count) from bookstore";
        ResultSet rs = DbUtils.doRequest(countSelect);
        try {
            if (rs.next()) {
                int count = rs.getInt(1);
                return count;
            } else {
                System.out.println("Result set empty!");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
