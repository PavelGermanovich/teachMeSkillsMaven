package homework.lesson13.task1;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Demo {
    /**
     * 1) Создать класс Книга
     * - артикул
     * - название
     * - год издания
     * - список книг из той-же серии(не названий книг, а Объектов книга)
     * В майн создать список книг, добавить в него 3-4 книги
     * Соформировать XML документ содержащий список ваших книг
     */
    public static void main(String[] args) throws JAXBException{
        Book bookFirst = new Book();
        bookFirst.setName("How important to be serious");
        bookFirst.setYear(1966);
        bookFirst.setVendorCode(123);

        Book bookSecond = new Book();
        bookSecond.setName("Gladiator");
        bookSecond.setYear(1987);
        bookSecond.setVendorCode(133);

        Book bookThird = new Book();
        bookThird.setName("Harry Potter");
        bookThird.setYear(1999);
        bookThird.setVendorCode(144);

        bookThird.addRelatedBook(bookFirst);
        bookThird.addRelatedBook(bookSecond);

        bookThird.addRelatedBookList(bookFirst);
        bookThird.addRelatedBookList(bookSecond);

        convertBookToXml(bookThird);
    }

    private static void convertBookToXml(Book book) throws JAXBException{
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Book.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(book, new File("src/main/java/homework/lesson13/task1/result.xml"));
        } catch (JAXBException e) {
            throw e;
        }

    }
}