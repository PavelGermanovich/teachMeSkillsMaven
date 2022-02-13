package homework.lesson13.task1;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "Book")
@XmlType(propOrder = {"name", "vendorCode", "year", "relatedBookAsList"})
public class Book {
    private int vendorCode;
    private String name;
    private int year;

    @XmlElementWrapper(name="RelatedBooks")
    @XmlElement(name = "relatedBook")
    private List<Book> relatedBookAsList = new ArrayList();

    @XmlAttribute
    public int getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(int articul) {
        this.vendorCode = articul;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void addRelatedBookList(Book book) {
        relatedBookAsList.add(book);
    }

    public List<Book> getRelatedBooksAsList() {
        return relatedBookAsList;
    }
}
